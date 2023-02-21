/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.controller.manager

import entity.user.User

/**
 * The interface for Database operations on [User].
 */
interface UserDatabaseManager {

    /** Insert a new [user] inside the database. */
    fun createUser(user: User): User?

    /** Delete a user from the database given its [userId]. */
    fun deleteUser(userId: String): Boolean

    /** Retrieve a user from the database given its [userId]. */
    fun getUser(userId: String): User?
}
