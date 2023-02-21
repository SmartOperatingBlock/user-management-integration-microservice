/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.service

import entity.healthprofessional.HealthProfessional
import usecase.repository.HealthProfessionalRepository

/**
 * The application service for health professionals management.
 * @param healthProfessionalRepository the repository to access health professionals data.
 */
class HealthProfessionalService(private val healthProfessionalRepository: HealthProfessionalRepository) {

    /** Get a health professional given its [healthProfessionalId]. */
    fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? =
        healthProfessionalRepository.getHealthProfessional(healthProfessionalId)

    /** Create a [HealthProfessional]. */
    fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional? =
        healthProfessionalRepository.createHealthProfessional(healthProfessional)

    /** Delete a [HealthProfessional] given its [healthProfessionalId]. */
    fun deleteHealthProfessional(healthProfessionalId: String): Boolean =
        healthProfessionalRepository.deleteHealthProfessional(healthProfessionalId)
}
