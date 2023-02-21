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
 * The interface for Digital Twins operations on [HealthProfessional].
 */
interface HealthProfessionalDigitalTwinsManager {

    /** Create a new [healthProfessional] Digital Twin. */
    fun createHealthProfessional(healthProfessional: HealthProfessional)

    /** Delete the Digital Twin of the given [healthProfessionalId]. */
    fun deleteHealthProfessional(healthProfessionalId: String)
}
