/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.digitaltwins.adtpresenter

import com.azure.digitaltwins.core.BasicDigitalTwin
import com.azure.digitaltwins.core.BasicDigitalTwinMetadata
import entity.healthprofessional.HealthProfessionalData.HealthProfessional

/**
 * Module with the data of Azure Digital Twin of Health Professional.
 */
object HealthProfessionalAdt {

    private const val HEALTH_PROFESSIONAL_MODEL = "dtmi:io:github:smartoperatingblock:HealthProfessional;1"
    private const val NAME_PROPERTY = "name"
    private const val SURNAME_PROPERTY = "surname"
    private const val ROLE_PROPERTY = "role"

    /**
     * Extension function to create a digital twin from the health professional.
     */
    fun HealthProfessional.toDigitalTwin(): BasicDigitalTwin =
        BasicDigitalTwin(this.healthProfessionalId)
            .setMetadata(BasicDigitalTwinMetadata().setModelId(HEALTH_PROFESSIONAL_MODEL))
            .addToContents(NAME_PROPERTY, this.name)
            .addToContents(SURNAME_PROPERTY, this.surname)
            .addToContents(ROLE_PROPERTY, this.role.ordinal)
}
