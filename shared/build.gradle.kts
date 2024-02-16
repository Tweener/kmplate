plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
}

android {
    namespace = Dependencies.Versions.MyProject.packageName
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

    // region iOS configuration

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true

            // Add here any extra framework dependencies
            export(project(":shared:data"))
            export(project(":shared:domain"))
            export(project(":shared:presentation"))
        }
    }

    // endregion iOS configuration

    sourceSets {
        commonMain.dependencies {
            api(project(":shared:data"))
            api(project(":shared:domain"))
            api(project(":shared:presentation"))

            // Everything below this part is for the Presentation layer
            // Since Compose Multiplatform 1.6.0 is not yet compatible with multi-modules projects, we can't use Presentation module yet

            // Tweener
            implementation(Dependencies.Libraries.Tweener.czan)
            implementation(Dependencies.Libraries.Tweener.common)
            implementation(Dependencies.Libraries.Tweener.firebase)

            // Kotlin
            implementation(Dependencies.Libraries.Coroutines.core)
            implementation(Dependencies.Libraries.kotlinXDatetime)

            // Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(Dependencies.Libraries.ComposeMultiplatform.material3)

            // DI
            implementation(Dependencies.Libraries.Koin.core)
            implementation(Dependencies.Libraries.Koin.compose)

            // Napier
            implementation(Dependencies.Libraries.napier)

            // Image fetcher
            implementation(Dependencies.Libraries.Coil.compose)
            implementation(Dependencies.Libraries.Coil.network)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // DI
            implementation(Dependencies.Libraries.Koin.android)
        }
    }
}
