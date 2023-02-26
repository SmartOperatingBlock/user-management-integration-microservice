/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.service.mock

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.UserDatabaseManager
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import entity.user.User

class MockDBManager : UserDatabaseManager, HealthProfessionalDatabaseManager {

    private val users = mutableSetOf<User>()
    private val healthProfessionals = mutableSetOf<HealthProfessional>()

    override fun createHealthProfessional(healthProfessional: HealthProfessional): HealthProfessional? {
        healthProfessionals.add(healthProfessional)
        return getHealthProfessional(healthProfessional.healthProfessionalId)
    }

    override fun deleteHealthProfessional(healthProfessionalId: String): Boolean =
        healthProfessionals.removeIf { it.healthProfessionalId == healthProfessionalId }

    override fun getHealthProfessional(healthProfessionalId: String): HealthProfessional? =
        healthProfessionals.find { it.healthProfessionalId == healthProfessionalId }

    override fun createUser(user: User): User? {
        users.add(user)
        return getUser(user.userId)
    }

    override fun deleteUser(userId: String): Boolean =
        users.removeIf { it.userId == userId }

    override fun getUser(userId: String): User? =
        users.find { it.userId == userId }
}
