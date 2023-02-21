/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.controller

import application.controller.manager.UserDatabaseManager
import application.controller.manager.UserDigitalTwinsManager
import entity.user.User
import usecase.repository.UserRepository

/**
 * The controller of users operations.
 * It contains the logic to access and update user data.
 */
class UserController(
    private val dbManager: UserDatabaseManager,
    private val dtManager: UserDigitalTwinsManager
) : UserRepository {

    override fun createUser(user: User): User? =
        dtManager.createUser(user).run {
            dbManager.createUser(user)
        }

    override fun deleteUser(userId: String): Boolean =
        dtManager.deleteUser(userId).run {
            dbManager.deleteUser(userId)
        }

    override fun getUser(userId: String): User? = dbManager.getUser(userId)
}
