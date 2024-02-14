plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

android {
    namespace = Dependencies.Versions.MyProject.packageName + ".presentation"
    compileSdk = Dependencies.Versions.MyProject.Android.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.MyProject.Android.minSDK
    }

    compileOptions {
        sourceCompatibility = Dependencies.Versions.Compiler.javaCompatibility
        targetCompatibility = Dependencies.Versions.Compiler.javaCompatibility
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    // region Compose

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.Android.composeCompilerExtension
    }

    dependencies {
        debugApi(compose.uiTooling)
        debugApi(compose.components.uiToolingPreview)
        debugApi(Dependencies.Libraries.Android.AndroidX.Compose.uiTooling)
    }

    // endregion Compose
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
            api(Dependencies.Libraries.Tweener.czan)

            // Kotlin
            api(Dependencies.Libraries.Coroutines.core)
            api(Dependencies.Libraries.kotlinXDatetime)

            // Compose
            api(compose.runtime)
            api(compose.foundation)
            api(compose.material)
            api(compose.materialIconsExtended)
            api(compose.ui)
            api(compose.components.resources)
            api(compose.components.uiToolingPreview)
            api(Dependencies.Libraries.ComposeMultiplatform.material3)

            // DI
            api(Dependencies.Libraries.Kodein.core)
            api(Dependencies.Libraries.Kodein.compose)

            // Napier
            api(Dependencies.Libraries.napier)

            // Image fetcher
            api(Dependencies.Libraries.Coil.compose)
            api(Dependencies.Libraries.Coil.network)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // Compose
            api(Dependencies.Libraries.Android.AndroidX.Compose.uiToolingPreview)
            api(Dependencies.Libraries.Android.AndroidX.Compose.activity)
        }
    }
}
