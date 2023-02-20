/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.user

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class UserTest : StringSpec({

    "An User should not be empty" {
        shouldThrow<IllegalArgumentException> {
            User("", "")
        }
    }

    "A short password should throw exception" {
        shouldThrow<IllegalArgumentException> {
            User("userID", "short")
        }
    }

    "A right user should correctly be created " {
        val user = User("userID", "rightPassword")
        user.userId shouldBe "userID"
        user.password shouldBe "rightPassword"
    }
})
