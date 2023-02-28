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

    "Test user operations on mongo db" {
        withMongo {
            val mockUser = User("1234", "MockPassword!")

            val mongoClient = MongoClient("mongodb://localhost:27017")

            mongoClient.createUser(mockUser) shouldNotBe null

            mongoClient.deleteUser(mockUser.userId) shouldBe true

            mongoClient.createUser(mockUser) shouldNotBe null
            mongoClient.getUser(mockUser.userId).also {
                it shouldNotBe null
                it?.userId shouldBe mockUser.userId
            }
        }
    }
})
