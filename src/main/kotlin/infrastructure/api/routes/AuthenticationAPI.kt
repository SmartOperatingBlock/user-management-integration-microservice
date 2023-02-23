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
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.post
import usecase.AuthenticationUseCase

/**
 * The Authentication API implementation.
 */
fun Route.authAPI(provider: Provider) {

    post("/api/auth") {
        if (AuthenticationUseCase(
                call.parameters["password"].toString(),
                call.parameters["id"].toString(),
                UserController(provider.userDatabaseManager)
            ).execute()
        ) {
            call.respond(HttpStatusCode.OK)
        } else {
            call.respond(HttpStatusCode.Unauthorized, "Error: wrong credentials!")
        }
    }
}
