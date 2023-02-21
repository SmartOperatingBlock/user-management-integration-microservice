/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.healthprofessional

/**
 * Module with all the Health Professionals data.
 */
object HealthProfessionalData {

    /** The Surgeon health professional model. */
    data class Surgeon(
        override val healthProfessionalId: String,
        override val name: String,
        override val surname: String,
        override val gender: Gender,
        override val birthdate: Birthdate,
        override val emailAddress: String,
        override val phoneNumber: PhoneNumber,
        override val role: HealthProfessionalRole = HealthProfessionalRole.SURGEON
    ) : HealthProfessional {
        init {
            require(healthProfessionalId.isNotEmpty()) {
                throw IllegalArgumentException("Invalid HealthProfessional ID!")
            }
        }
    }

    /** The Surgeon health professional model. */
    data class Nurse(
        override val healthProfessionalId: String,
        override val name: String,
        override val surname: String,
        override val gender: Gender,
        override val birthdate: Birthdate,
        override val emailAddress: String,
        override val phoneNumber: PhoneNumber,
        override val role: HealthProfessionalRole = HealthProfessionalRole.NURSE
    ) : HealthProfessional {
        init {
            require(healthProfessionalId.isNotEmpty()) {
                throw IllegalArgumentException("Invalid HealthProfessional ID!")
            }
        }
    }

    /** The Surgeon health professional model. */
    data class Anesthetist(
        override val healthProfessionalId: String,
        override val name: String,
        override val surname: String,
        override val gender: Gender,
        override val birthdate: Birthdate,
        override val emailAddress: String,
        override val phoneNumber: PhoneNumber,
        override val role: HealthProfessionalRole = HealthProfessionalRole.ANESTHETIST,
    ) : HealthProfessional {
        init {
            require(healthProfessionalId.isNotEmpty()) {
                throw IllegalArgumentException("Invalid HealthProfessional ID!")
            }
        }
    }

    /** All types of Health professional gender. */
    enum class Gender {
        MALE, FEMALE, OTHER,
    }

    /** All types of health professional role. */
    enum class HealthProfessionalRole {
        SURGEON, ANESTHETIST, NURSE,
    }

    /** The phone [number] preceded by the [prefix]. */
    data class PhoneNumber(
        val prefix: String,
        val number: String,
    )

    /** The model of the birthdate, composed by the [year], the [month] and the [day]. */
    data class Birthdate(val year: String, val month: String, val day: String) {
        override fun toString(): String {
            return "$year-$month-$day"
        }
    }
}
