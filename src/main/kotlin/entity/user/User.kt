/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package entity.user

import entity.user.UserData.PASSWORD_MAX_LENGTH
import entity.user.UserData.PASSWORD_MIN_LENGTH
import kotlinx.serialization.Serializable

/** The user of the Smart Operating block System. */
@Serializable
data class User(

    /** The identifier of the [User]. */
    val userId: String,

    /** The [password] of the [User]. */
    val password: String,
) {
    init {
        check(userId.isNotEmpty()) {
            "Invalid userId!"
        }

        check(password.length in PASSWORD_MIN_LENGTH..PASSWORD_MAX_LENGTH) {
            "Invalid user password!"
        }
    }

    override fun equals(other: Any?): Boolean = when {
        other === this -> true
        other is User -> userId == other.userId
        else -> false
    }

    override fun hashCode(): Int {
        return userId.hashCode()
    }
}
