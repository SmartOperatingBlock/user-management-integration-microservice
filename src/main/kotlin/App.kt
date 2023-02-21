/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

import application.provider.Provider
import infrastructure.api.APIRouter
import infrastructure.db.MongoClient
import infrastructure.dt.AzureDTClient

/** The application launcher. */
fun main() {
    val provider = Provider(MongoClient(), AzureDTClient())
    APIRouter(provider).start()
}
