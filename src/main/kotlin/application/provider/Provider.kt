/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package application.provider

import application.controller.manager.UserDatabaseManager
import application.controller.manager.UserDigitalTwinsManager

/**
 * It's responsible to provide the [dbManager] and [dtManager] to User and HealthProfessionals managers.
 */
data class Provider(
    val dbManager: UserDatabaseManager,
    val dtManager: UserDigitalTwinsManager,
)
