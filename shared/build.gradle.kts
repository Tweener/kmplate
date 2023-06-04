plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
}

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    targetHierarchy.default()

    // region Android configuration

    android {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }

    // endregion Android configuration

    // region iOS configuration

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        // Configure the Pod name here instead of changing the Gradle project name
        name = "MyProjectCocoaPod"

        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"

        ios.deploymentTarget = Dependencies.Versions.Tropse.IOS.deploymentTarget
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"

            // Add here any extra framework dependencies, ie.: export(project(":shared:data"))
        }
    }

    // endregion iOS configuration

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    namespace = Dependencies.Versions.Tropse.packageName
    compileSdk = Dependencies.Versions.Tropse.Android.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.Tropse.Android.minSDK
    }
}
