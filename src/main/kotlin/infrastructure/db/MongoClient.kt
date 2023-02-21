/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.db

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.UserDatabaseManager
import entity.healthprofessional.HealthProfessional
import entity.user.User

/**
 * The Mongo client.
 */
class MongoClient : UserDatabaseManager, HealthProfessionalDatabaseManager {

//    init {
//        requireNotNull(System.getenv("USER_MANAGEMENT_MONGODB_URL")) {
//            println("Please provide the User Management MongoDB connection string!")
//        }
//    }

    override fun createUser(user: User): User? {
        TODO("Not yet implemented")
    }

    override fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional? {
        TODO("Not yet implemented")
    }

    override fun deleteUser(userId: String): Boolean {
        println("deleting user")
        return false
    }

    override fun deleteHealthProfessional(healthProfessionalId: String): Boolean {
        TODO("Not yet implemented")
    }

    override fun getUser(userId: String): User? {
        TODO("Not yet implemented")
    }

    override fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? {
        TODO("Not yet implemented")
    }

//    private val client =
//    KMongo.createClient(
//    "mongodb+srv://user:admin@usermanagementcluster.ql5hmbx.mongodb.net/?retryWrites=true&w=majority"
//    )
}
