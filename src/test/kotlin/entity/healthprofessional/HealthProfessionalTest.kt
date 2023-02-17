/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.healthprofessional

import entity.healthprofessional.HealthProfessionalData.Anesthetist
import entity.healthprofessional.HealthProfessionalData.Gender
import entity.healthprofessional.HealthProfessionalData.HealthProfessionalRole
import entity.healthprofessional.HealthProfessionalData.Nurse
import entity.healthprofessional.HealthProfessionalData.PhoneNumber
import entity.healthprofessional.HealthProfessionalData.Surgeon
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HealthProfessionalTest : StringSpec({

    val surgeon: HealthProfessional = Surgeon(
        "surgeonID",
        "Jack",
        "Fritz",
        Gender.MALE,
        "22/04/1980",
        "jackfritz@gmail.com",
        PhoneNumber("+39", "3328455753")
    )

    val nurse: HealthProfessional = Nurse(
        "nurseID",
        "Jack",
        "Fritz",
        Gender.MALE,
        "22/04/1980",
        "jackfritz@gmail.com",
        PhoneNumber("+39", "3328455753")
    )

    val anesthetist: HealthProfessional = Anesthetist(
        "anesthetistID",
        "Jack",
        "Fritz",
        Gender.MALE,
        "22/04/1980",
        "jackfritz@gmail.com",
        PhoneNumber("+39", "3328455753")
    )

    "An Healh Professional ID should not be empty" {
        shouldThrow<IllegalArgumentException> {
            Surgeon(
                "",
                "Jack",
                "Fritz",
                Gender.MALE,
                "22/04/1980",
                "jackfritz@gmail.com",
                PhoneNumber("+39", "3328455753")
            )
        }
    }

    "A surgeon should correctly be created " {
        surgeon.role shouldBe HealthProfessionalRole.SURGEON
    }

    "A nurse should correctly be created " {
        nurse.role shouldBe HealthProfessionalRole.NURSE
    }

    "An anesthetist should correctly be created " {
        anesthetist.role shouldBe HealthProfessionalRole.ANESTHETIST
    }
})
