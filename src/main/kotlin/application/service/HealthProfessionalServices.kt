/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.service

import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import usecase.repository.HealthProfessionalRepository

/**
 * The module with health professionals application services.
 */
object HealthProfessionalServices {

    /**
     * Application service to create a [healthProfessional] using the [healthProfessionalRepository].
     */
    class CreateHealthProfessional(
        private val healthProfessional: HealthProfessional,
        private val healthProfessionalRepository: HealthProfessionalRepository,
    ) : ApplicationService<HealthProfessional?> {
        override fun execute(): HealthProfessional? =
            if (healthProfessionalRepository.getHealthProfessional(healthProfessional.healthProfessionalId) == null) {
                healthProfessionalRepository.createHealthProfessional(healthProfessional)
            } else {
                null
            }
    }

    /**
     * Application service to delete a Health Professional
     * given its [healthProfessionalId] using the [healthProfessionalRepository].
     */
    class DeleteHealthProfessional(
        private val healthProfessionalId: String,
        private val healthProfessionalRepository: HealthProfessionalRepository,
    ) : ApplicationService<Boolean> {
        override fun execute(): Boolean =
            healthProfessionalRepository.deleteHealthProfessional(healthProfessionalId)
    }

    /**
     * Application service to get a Health Professional
     * given its [healthProfessionalId] using the [healthProfessionalRepository].
     */
    class GetHealthProfessional(
        private val healthProfessionalId: String,
        private val healthProfessionalRepository: HealthProfessionalRepository,
    ) : ApplicationService<HealthProfessional?> {
        override fun execute(): HealthProfessional? =
            healthProfessionalRepository.getHealthProfessional(healthProfessionalId)
    }
}
