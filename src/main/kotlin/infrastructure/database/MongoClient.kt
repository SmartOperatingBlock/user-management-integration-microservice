/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.database

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.UserDatabaseManager
import com.mongodb.client.MongoDatabase
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.user.User
import org.litote.kmongo.KMongo
import org.litote.kmongo.eq
import org.litote.kmongo.findOne
import org.litote.kmongo.getCollection

/**
 * The Mongo client.
 */
class MongoClient(
    connectionString: String
) : UserDatabaseManager, HealthProfessionalDatabaseManager {

    init {
        check(connectionString.isNotEmpty()) {
            "Please provide the User Management MongoDB connection string!"
        }
    }

    private val client = KMongo.createClient(connectionString)

    private val userCollection =
        client.getDatabase(databaseName).getCollection<User>("users")

    private val healthProfessionalCollection =
        client.getDatabase(databaseName).getCollection<HealthProfessional>("health_professionals")

    /** Return a database given its [databaseName]. **/
    fun getDatabase(databaseName: String): MongoDatabase = client.getDatabase(databaseName)

    override fun createUser(user: User): User? =
        userCollection.insertOne(user).run {
            getUser(user.userId)
        }

    override fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional? =
        healthProfessionalCollection.insertOne(healthProfessional).run {
            getHealthProfessional(healthProfessional.healthProfessionalId)
        }

    override fun deleteUser(userId: String): Boolean =
        userCollection.deleteOne(User::userId eq userId).deletedCount > 0

    override fun deleteHealthProfessional(healthProfessionalId: String): Boolean =
        healthProfessionalCollection.deleteOne(HealthProfessional::healthProfessionalId eq healthProfessionalId)
            .deletedCount > 0

    override fun getUser(userId: String): User? =
        userCollection.findOne(User::userId eq userId)

    override fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? =
        healthProfessionalCollection.findOne(HealthProfessional::healthProfessionalId eq healthProfessionalId)

    companion object {
        /** The name of the database. */
        const val databaseName = "user_management"
    }
}
