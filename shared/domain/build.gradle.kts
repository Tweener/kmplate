plugins {
    kotlin("multiplatform")
    id("com.android.library")
}

android {
    namespace = Dependencies.Versions.MyProject.packageName + ".domain"
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
            // DI
            implementation(Dependencies.Libraries.Koin.core)

            // Napier
            implementation(Dependencies.Libraries.napier)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        iosMain.dependencies {
            // Ktor
            implementation(Dependencies.Libraries.Ktor.Client.iOS.client)
        }
    }
}
