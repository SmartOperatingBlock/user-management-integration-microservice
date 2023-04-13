/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import application.controller.UserController
import application.service.UserServices
import entity.user.User
import infrastructure.provider.Provider
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.post

/**
 * The User API implementation.
 */
fun Route.userAPI(provider: Provider, apiPath: String) {
    get("$apiPath/users/{userId}") {
        val userId = call.parameters["userId"].toString()
        UserServices.GetUser(
            userId,
            UserController(provider.userDatabaseManager),
        ).execute().apply {
            if (this != null) {
                call.respond(HttpStatusCode.OK, this)
            } else {
                call.respond(HttpStatusCode.NotFound, "User: $userId not found!")
            }
        }
    }

    delete("$apiPath/users/{userId}") {
        val userId = call.parameters["userId"].toString()
        UserServices.DeleteUser(
            userId,
            UserController(provider.userDatabaseManager),
        ).execute().apply {
            if (this) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "User: $userId not found!")
            }
        }
    }

    post("$apiPath/users") {
        val user = call.receive<User>()
        UserServices.CreateUser(
            user,
            UserController(provider.userDatabaseManager),
        ).execute().apply {
            if (this != null) {
                call.respond(HttpStatusCode.Created)
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }
}
