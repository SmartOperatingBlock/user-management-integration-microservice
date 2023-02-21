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
 * The interface for Digital Twins operations.
 */
interface UserDigitalTwinsManager {

    /** Create a new [user] Digital Twin. */
    fun createUser(user: User)

    /** Delete the Digital Twin of the given [userId]. */
    fun deleteUser(userId: String)
}
