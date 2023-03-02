/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.healthprofessional

import kotlinx.serialization.Serializable

/**
 * Module with all the Health Professionals data.
 */
object HealthProfessionalData {

    /** The health professional model. */
    @Serializable
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
        val birthdate: String,
        /** The health professional email address. */
        val emailAddress: String,
        /** The health professional phone number. */
        val phoneNumber: String,
        /** The health professional role. */
        val role: HealthProfessionalRole
    ) {
        init {
            check(healthProfessionalId.isNotEmpty()) {
                "Invalid HealthProfessional ID!"
            }
        }

        override fun equals(other: Any?): Boolean = when {
            other === this -> true
            other is HealthProfessional -> healthProfessionalId == other.healthProfessionalId
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
}
