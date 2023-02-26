/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.service

import application.controller.UserController
import application.service.mock.MockDBManager
import entity.user.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class TestApplicationService : StringSpec({

    var userController = UserController(MockDBManager())
    val mockUser = User("00000001", "User1999!")

    beforeEach {
        userController = UserController(MockDBManager())
    }

    "The application service should be able to create a User!" {
        userController.createUser(mockUser).also {
            it shouldNotBe null
            userController.getUser(mockUser.userId) shouldBe mockUser
        }
    }

    "The application service should be able to get a User!" {
        userController.createUser(mockUser)
        userController.getUser(mockUser.userId).also {
            it shouldNotBe null
            it shouldBe mockUser
        }
    }

    "The application service should be able to delete a User!" {
        userController.createUser(mockUser)
        userController.deleteUser(mockUser.userId).also {
            it shouldBe true
        }
    }
})
