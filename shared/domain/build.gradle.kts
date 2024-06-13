plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
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
            // Tweener
            implementation(project.dependencies.platform(libs.tweener.bom))
            implementation(libs.tweener.common)

            // DI
            implementation(libs.koin.core)

            // Napier
            implementation(libs.napier)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        iosMain.dependencies {
        }
    }
}
