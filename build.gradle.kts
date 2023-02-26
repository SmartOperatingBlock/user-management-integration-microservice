/*
 * Copyright (c) 2023. Smart Operating Block
 *
 * Use of this source code is governed by an MIT-style
 * license that can be found in the LICENSE file or at
 * https://opensource.org/licenses/MIT.
 */

plugins {
    application
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.qa)
    alias(libs.plugins.dokka)
    alias(libs.plugins.kotlin.serialization)
}

group = "io.github.smartoperatingblock"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.kmongo)
    implementation(libs.kotlin.stdlib)
    implementation(libs.ktor.server.core)
    implementation(libs.ktor.server.netty)
    implementation(libs.ktor.server.swagger)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.serialization)
    implementation(libs.logback)
    testImplementation(libs.bundles.kotlin.testing)
}

kotlin {
    target {
        compilations.all {
            kotlinOptions {
                allWarningsAsErrors = true
            }
        }
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        showStandardStreams = true
        showCauses = true
        showStackTraces = true
        events(*org.gradle.api.tasks.testing.logging.TestLogEvent.values())
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }
}

application {
    mainClass.set("AppKt")
}
