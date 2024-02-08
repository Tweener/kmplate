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

            // Kotlin
            implementation(Dependencies.Libraries.Coroutines.core)
            implementation(Dependencies.Libraries.kotlinXDatetime)

            // DI
            implementation(Dependencies.Libraries.Kodein.core)

            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.core)
            implementation(Dependencies.Libraries.Ktor.Client.auth)
            implementation(Dependencies.Libraries.Ktor.Client.contentNegotiation)
            implementation(Dependencies.Libraries.Ktor.Client.logging)
            implementation(Dependencies.Libraries.Ktor.serializationJson)

            // Napier
            implementation(Dependencies.Libraries.napier)

            // Realm
            implementation(Dependencies.Libraries.realm)

            // Firestore
            implementation(Dependencies.Libraries.Firebase.firestore)
            implementation(Dependencies.Libraries.Firebase.config)
            implementation(Dependencies.Libraries.Firebase.auth)
            implementation(Dependencies.Libraries.Firebase.functions)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.Android.okhttp)

            // LoggingInterceptor: An OkHttp interceptor for logging network requests and responses
            implementation(Dependencies.Libraries.Android.loggingInterceptor) {
                exclude(group = "org.json", module = "json")
            }
        }

        iosMain.dependencies {
            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.iOS.client)
        }
    }
}
