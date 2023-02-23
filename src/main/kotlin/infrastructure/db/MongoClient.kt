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
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.user.User
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

/**
 * The Mongo client.
 */
class MongoClient : UserDatabaseManager, HealthProfessionalDatabaseManager {

    init {
        checkNotNull(System.getenv("USER_MANAGEMENT_MONGODB_URL")) {
            "Please provide the User Management MongoDB connection string!"
        }
    }

    companion object {
        /** The name of the database. */
        const val databaseName = "user_management"
    }

    private val client = KMongo.createClient(System.getenv("USER_MANAGEMENT_MONGODB_URL"))
    private val userCollection =
        client.getDatabase(databaseName).getCollection<User>("users")
    private val healthProfessionalCollection =
        client.getDatabase(databaseName).getCollection<HealthProfessional>("health_professionals")

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

    override fun getUser(userId: String): User? =
        userCollection.findOne(User::userId eq userId)

    override fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? =
        healthProfessionalCollection.findOne(HealthProfessional::healthProfessionalId eq healthProfessionalId)
}
