plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.realm)
    alias(libs.plugins.kotlin.serialization)
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
            implementation(project.dependencies.platform(libs.tweener.bom))
            implementation(libs.tweener.common)
            implementation(libs.tweener.realm)
            implementation(libs.tweener.firebase)

            // DI
            implementation(libs.koin.core)

            // Ktor
            implementation(libs.bundles.ktor.common)

            // Napier
            implementation(libs.napier)

            // Multiplatform Settings (equivalent to SharedPrefs but for all platforms)
            api(libs.bundles.multiplaform.settings)

            // Realm
            api(libs.realm)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // Ktor
            implementation(libs.ktor.client.android)
        }

        iosMain.dependencies {
            // Ktor
            implementation(libs.ktor.client.ios)
        }
    }
}
