/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.controller.manager

import entity.healthprofessional.HealthProfessional

/**
 * The interface for Database operations on [HealthProfessional].
 */
interface HealthProfessionalDatabaseManager {

    /** Insert a new [healthProfessional] inside the database. */
    fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional?

    /** Delete a health professional from the database given its [healthProfessionalId]. */
    fun deleteHealthProfessional(healthProfessionalId: String): Boolean

    /** Retrieve an health professional from the database given its [healthProfessionalId]. */
    fun getHealthProfessional(healthProfessionalId: String): HealthProfessional?
}
