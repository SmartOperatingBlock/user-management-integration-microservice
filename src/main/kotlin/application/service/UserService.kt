/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.service

import entity.user.User
import usecase.repository.UserRepository

/**
 * The application service for user management.
 * @param userRepository the repository to access user data.
 */
class UserService(private val userRepository: UserRepository) {

    /** Get a user given its [userId]. */
    fun getUser(userId: String): User? = userRepository.getUser(userId)

    /** Create a [User]. */
    fun createUser(user: User): User? = userRepository.createUser(user)

    /** Delete a [User] given its [userId]. */
    fun deleteUser(userId: String): Boolean = userRepository.deleteUser(userId)
}
