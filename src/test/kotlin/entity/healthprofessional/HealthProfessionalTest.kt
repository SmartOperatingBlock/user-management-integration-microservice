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
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.healthprofessional.HealthProfessionalData.HealthProfessionalRole
import entity.healthprofessional.HealthProfessionalData.PhoneNumber
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HealthProfessionalTest : StringSpec({

    val healthProfessional = HealthProfessional(
        "surgeonID",
        "Jack",
        "Fritz",
        Gender.MALE,
        Birthdate("1999", "20", "3"),
        "jackfritz@gmail.com",
        PhoneNumber("+39", "3328455753"),
        HealthProfessionalRole.ANESTHETIST
    )

    "An Healh Professional ID should not be empty" {
        shouldThrow<IllegalArgumentException> {
            HealthProfessional(
                "",
                "Jack",
                "Fritz",
                Gender.MALE,
                Birthdate("1999", "20", "3"),
                "jackfritz@gmail.com",
                PhoneNumber("+39", "3328455753"),
                HealthProfessionalRole.ANESTHETIST
            )
        }
    }

    "A health professional should correctly be created " {
        healthProfessional.role shouldBe HealthProfessionalRole.ANESTHETIST
    }
})
