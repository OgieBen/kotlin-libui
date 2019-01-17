// Top-level build file where you can add configuration options common to all sub-projects/modules.
// SPDX-License-Identifier: MIT

@file:Suppress("SpellCheckingInspection")

plugins {
    id("org.jetbrains.dokka") version "0.9.17"
    id("org.jetbrains.kotlin.multiplatform") version "1.3.20-eap-100" apply false
    id("de.undercouch.download") version "3.4.3" apply false
    id("com.jfrog.bintray") version "1.8.3-kotlin-a1" apply false
}

allprojects {
    repositories {
        maven { url = uri("https://dl.bintray.com/kotlin/kotlin-eap") }
        mavenCentral()
    }
}

apply {
    from("dokka.gradle")
}
