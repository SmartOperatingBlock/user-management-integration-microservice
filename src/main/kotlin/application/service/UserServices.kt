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
 * The module with users application services.
 */
object UserServices {

    /**
     * Application service to create a [user] using the [userRepository].
     */
    class CreateUser(private val user: User, private val userRepository: UserRepository) : ApplicationService<User?> {
        override fun execute(): User? =
            if (userRepository.getUser(user.userId) == null) {
                userRepository.createUser(user)
            } else {
                null
            }
    }

    /**
     * Application service to delete a user given its [userId] using the [userRepository].
     */
    class DeleteUser(
        private val userId: String,
        private val userRepository: UserRepository,
    ) : ApplicationService<Boolean> {
        override fun execute(): Boolean = userRepository.deleteUser(userId)
    }

    /**
     * Application service to get a User given its [userId] using the [userRepository].
     */
    class GetUser(
        private val userId: String,
        private val userRepository: UserRepository,
    ) : ApplicationService<User?> {
        override fun execute(): User? = userRepository.getUser(userId)
    }
}
