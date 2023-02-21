/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import application.controller.UserController
import infrastructure.provider.Provider
import application.service.UserService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

/**
 * The User API implementation.
 */
fun Route.userAPI(provider: Provider) {

    with(UserService(UserController(provider.userDatabaseManager, provider.userDigitalTwinsManager))) {

        get("/api/users/{userId}") {
            call.parameters["userId"]?.let { userId ->
                getUser(userId)?.let {
                    call.respond(HttpStatusCode.OK, it)
                }
                call.respond(HttpStatusCode.Accepted, "User: $userId not found!")
            }
        }
    }
}
