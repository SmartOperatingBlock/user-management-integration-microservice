/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.controller

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.HealthProfessionalDigitalTwinsManager
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import usecase.repository.HealthProfessionalRepository

/**
 * The controller of health professionals operations.
 * It contains the logic to access and update health professionals data.
 */
class HealthProfessionalController(
    private val dbManager: HealthProfessionalDatabaseManager,
    private val dtManager: HealthProfessionalDigitalTwinsManager
) : HealthProfessionalRepository {

    override fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional? =
        dtManager.createHealthProfessional(healthProfessional).let {
            dbManager.createHealthProfessional(healthProfessional)
        }

    override fun deleteHealthProfessional(healthProfessionalId: String): Boolean =
        dtManager.deleteHealthProfessional(healthProfessionalId).let {
            dbManager.deleteHealthProfessional(healthProfessionalId)
        }

    override fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? =
        dbManager.getHealthProfessional(healthProfessionalId)
}
