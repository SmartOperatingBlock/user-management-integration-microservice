/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api.routes

import io.ktor.server.application.call
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

/**
 * The HealthProfessional API implementation.
 */
fun Route.healthProfessionalAPI() {
    get("/api/healthProfessional") {
        call.respondText { "OK" }
    }
}
