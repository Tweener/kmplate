import org.jetbrains.compose.ExperimentalComposeLibrary

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

    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    dependencies {
        debugApi(compose.uiTooling)
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

            implementation(Dependencies.Libraries.kotlinXDatetime)

            // Tweener
            implementation(Dependencies.Libraries.Tweener.czan)

            // Kotlin
            implementation(Dependencies.Libraries.Coroutines.core)
            implementation(Dependencies.Libraries.kotlinXDatetime)

            // Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            @OptIn(ExperimentalComposeLibrary::class)
            implementation(compose.components.resources)
            implementation(Dependencies.Libraries.ComposeMultiplatform.material3)

            // DI
            implementation(Dependencies.Libraries.Kodein.core)
            implementation(Dependencies.Libraries.Kodein.compose)

            // Napier
            implementation(Dependencies.Libraries.napier)

            // Image fetcher
            api(Dependencies.Libraries.Coil.compose)
            api(Dependencies.Libraries.Coil.network)

            // Kmpalette
            implementation(Dependencies.Libraries.Ktor.Client.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // Compose
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.uiToolingPreview)
            implementation(Dependencies.Libraries.Android.AndroidX.Compose.activity)
        }
    }
}
