/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.provider

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.HealthProfessionalDigitalTwinsManager
import application.controller.manager.UserDatabaseManager
import infrastructure.database.MongoClient
import infrastructure.digitaltwins.AzureDTClient

/**
 * The implementation of the [Provider] interface.
 */
class ProviderImpl : Provider {

    init {
        checkNotNull(System.getenv("USER_MANAGEMENT_MONGODB_URL")) {
            "Please provide a valid MongoDB connection String! "
        }
    }

    override val userDatabaseManager: UserDatabaseManager by lazy {
        MongoClient(System.getenv("USER_MANAGEMENT_MONGODB_URL"))
    }

    override val healthProfessionalDatabaseManager: HealthProfessionalDatabaseManager by lazy {
        MongoClient(System.getenv("USER_MANAGEMENT_MONGODB_URL"))
    }

    override val healthProfessionalDigitalTwinsManager: HealthProfessionalDigitalTwinsManager by lazy {
        AzureDTClient()
    }
}
