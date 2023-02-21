/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.dt

import application.controller.manager.HealthProfessionalDigitalTwinsManager
import application.controller.manager.UserDigitalTwinsManager
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.user.User

/**
 * The Azure Digital Twins Client.
 * It contains the implementation of Digital Twins operations.
 */
class AzureDTClient : UserDigitalTwinsManager, HealthProfessionalDigitalTwinsManager {

    override fun createUser(user: User) {
        TODO("Not yet implemented")
    }

    override fun createHealthProfessional(healthProfessional: HealthProfessional) {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: String) {
        TODO("Not yet implemented")
    }

    override fun deleteHealthProfessional(healthProfessionalId: String) {
        TODO("Not yet implemented")
    }
}
