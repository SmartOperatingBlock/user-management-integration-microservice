/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package usecase

import usecase.repository.UserRepository

/**
 * The use case of user authentication given the [userId] and the [password].
 * @param userRepository the repository to access user data.
 */
class AuthenticationUseCase(
    private val userId: String,
    private val password: String,
    private val userRepository: UserRepository
) : UseCase<Boolean> {

    override fun execute(): Boolean =
        userRepository.getUser(userId).let {
            it?.password.equals(password)
        }
}
