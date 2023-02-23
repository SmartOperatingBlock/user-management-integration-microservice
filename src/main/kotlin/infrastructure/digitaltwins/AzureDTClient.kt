/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

package infrastructure.digitaltwins

import application.controller.manager.HealthProfessionalDigitalTwinsManager
import com.azure.digitaltwins.core.BasicDigitalTwin
import com.azure.digitaltwins.core.BasicRelationship
import com.azure.digitaltwins.core.DigitalTwinsClientBuilder
import com.azure.digitaltwins.core.implementation.models.ErrorResponseException
import com.azure.identity.DefaultAzureCredentialBuilder
import entity.healthprofessional.HealthProfessionalData.HealthProfessional
import infrastructure.digitaltwins.adtpresenter.HealthProfessionalAdt.toDigitalTwin

/**
 * The Azure Digital Twins Client.
 * It contains the implementation of Digital Twins operations.
 */
class AzureDTClient : HealthProfessionalDigitalTwinsManager {

    init {
        checkNotNull(System.getenv("AZURE_CLIENT_ID")) {
            "Azure Client App Id required!"
        }
        checkNotNull(System.getenv("AZURE_TENANT_ID")) {
            "Azure Tenant Id required!"
        }
        checkNotNull(System.getenv("AZURE_CLIENT_SECRET")) {
            "Azure Client Secret required!"
        }
        checkNotNull(System.getenv("AZURE_DT_ENDPOINT")) {
            "Azure Digital Twin Endpoint required!"
        }
    }

    private val client = DigitalTwinsClientBuilder()
        .credential(DefaultAzureCredentialBuilder().build())
        .endpoint(System.getenv("AZURE_DT_ENDPOINT"))
        .buildClient()

    override fun createHealthProfessional(healthProfessional: HealthProfessional): Boolean {
        with(healthProfessional.toDigitalTwin()) {
            try {
                client.createOrReplaceDigitalTwin(this.id, this, BasicDigitalTwin::class.java)
                return true
            } catch (e: ErrorResponseException) {
                println(e)
                return false
            }
        }
    }

    override fun deleteHealthProfessional(healthProfessionalId: String): Boolean =
        try {
            client.listIncomingRelationships(healthProfessionalId).forEach {
                client.deleteRelationship(it.sourceId, it.relationshipId)
            }
            client.listRelationships(healthProfessionalId, BasicRelationship::class.java).forEach {
                client.deleteRelationship(it.sourceId, it.id)
            }
            client.deleteDigitalTwin(healthProfessionalId)
            true
        } catch (e: ErrorResponseException) {
            println(e)
            false
        }
}
