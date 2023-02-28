/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.healthprofessional

import entity.healthprofessional.HealthProfessionalData.Gender
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.healthprofessional.HealthProfessionalData.HealthProfessionalRole
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class HealthProfessionalTest : StringSpec({

    val healthProfessional = HealthProfessional(
        "surgeonID",
        "Jack",
        "Fritz",
        Gender.MALE,
        "1999-20-03",
        "jackfritz@gmail.com",
        "+39 3328455753",
        HealthProfessionalRole.ANESTHETIST
    )

    "An Healh Professional ID should not be empty" {
        shouldThrow<IllegalStateException> {
            HealthProfessional(
                "",
                "Jack",
                "Fritz",
                Gender.MALE,
                "1999-20-03",
                "jackfritz@gmail.com",
                "+39 3328455753",
                HealthProfessionalRole.ANESTHETIST
            )
        }
    }

    "A health professional should correctly be created " {
        healthProfessional.role shouldBe HealthProfessionalRole.ANESTHETIST
    }
})
