/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import application.controller.UserController
import application.service.UserService
import entity.user.User
import infrastructure.provider.Provider
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post

/**
 * The User API implementation.
 */
fun Route.userAPI(provider: Provider) {

    with(UserService(UserController(provider.userDatabaseManager, provider.userDigitalTwinsManager))) {

        get("/api/users/{userId}") {
            val userId = call.parameters["userId"].toString()
            val user: User? = getUser(userId)
            if (user != null) {
                call.respond(HttpStatusCode.OK, user)
            } else {
                call.respond(HttpStatusCode.NotFound, "User: $userId not found!")
            }
        }

        delete("/api/users/{userId}") {
            val userId = call.parameters["userId"].toString()
            val deleted = deleteUser(userId)
            if (deleted) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "User: $userId not found!")
            }
        }

        post("/api/users/") {
            val userId = call.parameters["userId"].toString()
            val password = call.parameters["password"].toString()
            if (getUser(userId) == null) {
                val user: User? = createUser(User(userId, password))
                if (user != null) {
                    call.respond(HttpStatusCode.Accepted)
                }
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }
}
