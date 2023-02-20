/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package usecase.repository

import entity.healthprofessional.HealthProfessional

/**
 * The repository for health professionals management.
 */
interface HealthProfessionalRepository {

    /** Create the given [healthProfessional]. */
    fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional?

    /** Delete the given [HealthProfessional] from its [healthProfessionalId] . */
    fun deleteHealthProfessional(healthProfessionalId: String): Boolean

    /** Returns a [HealthProfessional] given its [healthProfessionalId]. */
    fun getHealthProfessional(healthProfessionalId: String): HealthProfessional
}
