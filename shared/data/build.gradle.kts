plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("io.realm.kotlin")
    kotlin("plugin.serialization")
}

android {
    namespace = Dependencies.Versions.MyProject.packageName + ".data"
    compileSdk = Dependencies.Versions.MyProject.Android.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.MyProject.Android.minSDK
    }

    compileOptions {
        sourceCompatibility = Dependencies.Versions.Compiler.javaCompatibility
        targetCompatibility = Dependencies.Versions.Compiler.javaCompatibility
    }
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
            implementation(project(":shared:domain"))

            // Tweener
            implementation(Dependencies.Libraries.Tweener.common)
            implementation(Dependencies.Libraries.Tweener.realm)
            implementation(Dependencies.Libraries.Tweener.firebase)

            // Kotlin
            implementation(Dependencies.Libraries.Coroutines.core)
            implementation(Dependencies.Libraries.kotlinXDatetime)

            // DI
            implementation(Dependencies.Libraries.Koin.core)

            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.core)
            implementation(Dependencies.Libraries.Ktor.Client.auth)
            implementation(Dependencies.Libraries.Ktor.Client.contentNegotiation)
            implementation(Dependencies.Libraries.Ktor.Client.logging)
            implementation(Dependencies.Libraries.Ktor.serializationJson)

            // Napier
            implementation(Dependencies.Libraries.napier)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.Android.okhttp)
        }

        iosMain.dependencies {
            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.iOS.client)
        }
    }
}
