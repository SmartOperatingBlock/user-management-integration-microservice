/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.database

import entity.user.User
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class TestMongo : StringSpec({

    val mockUser = User("1234", "MockPassword!")

    "Test user creation on mongo db" {
        withMongo {
            val mongoClient = MongoClient("mongodb://localhost:27017").also {
                it.getDatabase("user_management").drop()
            }
            mongoClient.createUser(mockUser) shouldNotBe null
        }
    }

    "Test user deletion on mongo db" {
        withMongo {
            val mongoClient = MongoClient("mongodb://localhost:27017").also {
                it.getDatabase("user_management").drop()
            }
            mongoClient.createUser(mockUser)
            mongoClient.deleteUser(mockUser.userId) shouldBe true
        }
    }

    "Test user retrieve on mongo db" {
        withMongo {
            val mongoClient = MongoClient("mongodb://localhost:27017").also {
                it.getDatabase("user_management").drop()
            }
            mongoClient.createUser(mockUser)
            mongoClient.getUser(mockUser.userId).also {
                it shouldNotBe null
                it?.userId shouldBe mockUser.userId
            }
        }
    }
})
