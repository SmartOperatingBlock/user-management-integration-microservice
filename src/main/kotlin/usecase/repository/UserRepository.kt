/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package usecase.repository

import entity.user.User

/**
 * The repository for user management.
 */
interface UserRepository {

    /** Create the given [user]. */
    fun createUser(user: User): User?

    /** Delete a user from its [userId]. */
    fun deleteUser(userId: String): Boolean

    /** Returns a [User] given its [userId]. */
    fun getUser(userId: String): User?
}
