/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.api

import infrastructure.api.routes.authAPI
import infrastructure.api.routes.healthProfessionalAPI
import infrastructure.api.routes.userAPI
import infrastructure.provider.Provider
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.application.Application
import io.ktor.server.application.install
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.server.routing.routing

/**
 * The API router of the application.
 */
class APIRouter(private val provider: Provider) {

    private val version = "v1"
    private val apiPath: String = "/api/$version"

    companion object {
        /** The port of the KTor server. */
        const val NETTY_PORT = 3000
    }

    /** Start the Ktor server. */
    fun start() {
        embeddedServer(Netty, port = NETTY_PORT) {
            module(this)
        }.start(wait = true)
    }

    /** The KTor Application module. */
    fun module(app: Application) {
        with(app) {
            configureRouting()
            configureSerialization()
        }
    }

    /**
     * Extension function to configure routing management.
     */
    private fun Application.configureRouting() {
        routing {
            authAPI(provider, apiPath)
            userAPI(provider, apiPath)
            healthProfessionalAPI(provider, apiPath)
        }
    }

    /**
     * Extension function to configure serialization management.
     */
    private fun Application.configureSerialization() {
        install(ContentNegotiation) {
            json()
        }
    }
}
