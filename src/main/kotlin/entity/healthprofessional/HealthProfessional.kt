/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.healthprofessional

import entity.healthprofessional.HealthProfessionalData.Birthdate
import entity.healthprofessional.HealthProfessionalData.Gender
import entity.healthprofessional.HealthProfessionalData.HealthProfessionalRole
import entity.healthprofessional.HealthProfessionalData.PhoneNumber

/**
 * The Health Professional interface.
 */
interface HealthProfessional {

    /** The identifier of the [HealthProfessional]. */
    val healthProfessionalId: String

    /** The [name] of the [HealthProfessional]. */
    val name: String

    /** The [surname] of the [HealthProfessional]. */
    val surname: String

    /** The [gender] of the [HealthProfessional]. */
    val gender: Gender

    /** The [birthdate] of the [HealthProfessional]. */
    val birthdate: Birthdate

    /** The [emailAddress] of the [HealthProfessional]. */
    val emailAddress: String

    /** The [phoneNumber] of the [HealthProfessional]. */
    val phoneNumber: PhoneNumber

    /** The [role] of the [HealthProfessional]. */
    val role: HealthProfessionalRole
}
