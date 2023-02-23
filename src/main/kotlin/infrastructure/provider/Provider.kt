/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.provider

import application.controller.manager.HealthProfessionalDatabaseManager
import application.controller.manager.HealthProfessionalDigitalTwinsManager
import application.controller.manager.UserDatabaseManager

/**
 * It's responsible to provide the [userDatabaseManager], [userDigitalTwinsManager],
 * [healthProfessionalDatabaseManager] and [healthProfessionalDigitalTwinsManager]
 * to User and HealthProfessionals controllers.
 */
interface Provider {

    /** The manager of user operations inside database. */
    val userDatabaseManager: UserDatabaseManager

    /** The manager of health professionals operations inside database. */
    val healthProfessionalDatabaseManager: HealthProfessionalDatabaseManager

    /** The manager of health professional digital twin. */
    val healthProfessionalDigitalTwinsManager: HealthProfessionalDigitalTwinsManager
}
