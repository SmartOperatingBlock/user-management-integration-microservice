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

    /** The health professional model. */
    data class HealthProfessional(
        /** The health professional id. */
        val healthProfessionalId: String,
        /** The health professional name. */
        val name: String,
        /** The health professional surname. */
        val surname: String,
        /** The health professional gender. */
        val gender: Gender,
        /** The health professional birthdate. */
        val birthdate: Birthdate,
        /** The health professional email address. */
        val emailAddress: String,
        /** The health professional phone number. */
        val phoneNumber: PhoneNumber,
        /** The health professional role. */
        val role: HealthProfessionalRole
    ) {
        init {
            require(healthProfessionalId.isNotEmpty()) {
                throw IllegalArgumentException("Invalid HealthProfessional ID!")
            }
        }

        override fun equals(other: Any?): Boolean =
            when (other) {
                is HealthProfessional -> healthProfessionalId == other.healthProfessionalId
                else -> false
            }

        override fun hashCode(): Int {
            return healthProfessionalId.hashCode()
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
