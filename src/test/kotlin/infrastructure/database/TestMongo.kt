/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.database

import com.sun.jna.Platform
import entity.healthprofessional.HealthProfessionalData
import entity.user.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.utility.DockerImageName
import java.time.Duration

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

    lateinit var mongoClient: MongoClient

    lateinit var mongoContainer: MongoDBContainer

    beforeSpec {
        if (Platform.getOSType() == Platform.LINUX) {
            mongoContainer = MongoDBContainer(
                DockerImageName.parse("mongo:latest")
            ).withStartupTimeout(Duration.ofSeconds(60L))
            mongoContainer.start()
        }
        mongoClient = MongoClient("mongodb://localhost:27017")
    }

    afterSpec {
        if (Platform.getOSType() == Platform.LINUX) {
            mongoContainer.stop()
        }
    }

//    beforeAny {
//        mongoClient.getDatabase("user_management").drop()
//    }

    "test the creation of a user in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createUser(mockUser) shouldNotBe null
    }

    "test the creation of a health professional in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createHealthProfessional(mockHealthProfessional) shouldNotBe null
    }

    "test the retrieve of a user in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createUser(mockUser)
        mongoClient.getUser(mockUser.userId) shouldNotBe null
    }

    "test the retrieve of a health professional in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createHealthProfessional(mockHealthProfessional)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldNotBe null
    }

    "test the delete of a user in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createUser(mockUser)
        mongoClient.getUser(mockUser.userId) shouldNotBe null
        mongoClient.deleteUser(mockUser.userId)
        mongoClient.getUser(mockUser.userId) shouldBe null
    }

    "test the delete of a health professional in the database".config(
        enabled = Platform.getOSType() == Platform.LINUX
    ) {
        mongoClient.createHealthProfessional(mockHealthProfessional)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldNotBe null
        mongoClient.deleteHealthProfessional(mockHealthProfessional.healthProfessionalId)
        mongoClient.getHealthProfessional(mockHealthProfessional.healthProfessionalId) shouldBe null
    }
})
