/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import application.controller.HealthProfessionalController
import application.service.HealthProfessionalServices
import entity.healthprofessional.HealthProfessionalData
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
 * The HealthProfessional API implementation.
 */
fun Route.healthProfessionalAPI(provider: Provider, apiPath: String) {

    get("$apiPath/healthProfessionals/{healthProfessionalId}") {
        val healthProfessionalId = call.parameters["healthProfessionalId"].toString()
        HealthProfessionalServices.GetHealthProfessional(
            healthProfessionalId,
            HealthProfessionalController(
                provider.healthProfessionalDatabaseManager,
                provider.healthProfessionalDigitalTwinsManager
            )
        ).execute().apply {
            if (this != null) {
                call.respond(HttpStatusCode.OK, this)
            } else {
                call.respond(HttpStatusCode.NotFound, "HealthProfessional: $healthProfessionalId not found!")
            }
        }
    }

    delete("$apiPath/healthProfessionals/{healthProfessionalId}") {
        val healthProfessionalId = call.parameters["healthProfessionalId"].toString()
        HealthProfessionalServices.DeleteHealthProfessional(
            healthProfessionalId,
            HealthProfessionalController(
                provider.healthProfessionalDatabaseManager,
                provider.healthProfessionalDigitalTwinsManager
            )
        ).execute().apply {
            if (this) {
                call.respond(HttpStatusCode.NoContent)
            } else {
                call.respond(HttpStatusCode.NotFound, "HealthProfessional: $healthProfessionalId not found!")
            }
        }
    }

    post("$apiPath/healthProfessionals") {
        val healthProfessional = call.receive<HealthProfessionalData.HealthProfessional>()
        HealthProfessionalServices.CreateHealthProfessional(
            healthProfessional,
            HealthProfessionalController(
                provider.healthProfessionalDatabaseManager,
                provider.healthProfessionalDigitalTwinsManager
            )
        ).execute().apply {
            if (this != null) {
                call.respond(HttpStatusCode.Created)
            } else {
                call.respond(HttpStatusCode.Conflict)
            }
        }
    }
}
