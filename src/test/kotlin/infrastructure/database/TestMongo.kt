/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.database

import entity.healthprofessional.HealthProfessionalData
import entity.user.User
import io.kotest.core.extensions.install
import io.kotest.core.spec.style.StringSpec
import io.kotest.extensions.testcontainers.TestContainerExtension
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class TestMongo : StringSpec({

    val mockUser = User("00000000", "MockPassword!")
    val mockHealthProfessional = HealthProfessionalData.HealthProfessional(
        "surgeonID",
        "Jack",
        "Fritz",
        HealthProfessionalData.Gender.MALE,
        "1999-20-03",
        "jackfritz@gmail.com",
        "+39 3328455753",
        HealthProfessionalData.HealthProfessionalRole.ANESTHETIST
    )
    val mongoClient = MongoClient("mongodb://localhost:27017")

    install(TestContainerExtension("mongo:latest")) {
        withExposedPorts(27017)
    }.start()

    beforeAny {
        mongoClient.getDatabase("user_management").drop()
    }

    "test the creation of a user in the database" {
        mongoClient.createUser(mockUser) shouldNotBe null
    }

    "test the creation of a health professional in the database" {
        mongoClient.createHealthProfessional(mockHealthProfessional) shouldNotBe null
    }

    "test the retrieve of a user in the database" {
        mongoClient.createUser(mockUser)
        mongoClient.getUser(mockUser.userId) shouldNotBe null
    }

    "test the retrieve of a health professional in the database" {
        mongoClient.createHealthProfessional(mockHealthProfessional)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldNotBe null
    }

    "test the delete of a user in the database" {
        mongoClient.createUser(mockUser)
        mongoClient.getUser(mockUser.userId) shouldNotBe null
        mongoClient.deleteUser(mockUser.userId)
        mongoClient.getUser(mockUser.userId) shouldBe null
    }

    "test the delete of a health professional in the database" {
        mongoClient.createHealthProfessional(mockHealthProfessional)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldNotBe null
        mongoClient.deleteHealthProfessional(mockHealthProfessional.healthProfessionalId)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldBe null
    }
})
