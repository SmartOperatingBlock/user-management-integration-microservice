/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import application.controller.HealthProfessionalController
import infrastructure.provider.Provider
import application.service.HealthProfessionalService
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.call
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

/**
 * The HealthProfessional API implementation.
 */
fun Route.healthProfessionalAPI(provider: Provider) {

    with(HealthProfessionalService(HealthProfessionalController(
        provider.healthProfessionalDatabaseManager,
        provider.healthProfessionalDigitalTwinsManager,
    ))) {

        get("/api/healthProfessionals/{healthProfessionalId}") {
            call.parameters["healthProfessionalId"]?.let { healthProfessionalId ->
                getHealthProfessional(healthProfessionalId)?.let {
                    call.respond(HttpStatusCode.OK, it)
                }
                call.respond(HttpStatusCode.Accepted, "Health professional: $healthProfessionalId not found!")
            }
        }
    }
}
