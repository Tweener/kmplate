plugins {
    kotlin("multiplatform")
    id("com.android.library")
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
    android()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        val commonMain by getting {
            dependencies {
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
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }

        val androidMain by getting {
            dependencies {
                // Ktor
                implementation(Dependencies.Libraries.Ktor.Client.Android.okhttp)

                // LoggingInterceptor: An OkHttp interceptor for logging network requests and responses
                implementation(Dependencies.Libraries.Android.loggingInterceptor) {
                    exclude(group = "org.json", module = "json")
                }
            }
        }

        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                // Ktor
                implementation(Dependencies.Libraries.Ktor.Client.iOS.client)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}
