import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.codingfeline.buildkonfig:buildkonfig-gradle-plugin:${Dependencies.Versions.buildKonfig}")
    }
}

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.parcelize") // TODO Move this to Presentation build.gradle once Compose Multiplatform supports split modules
    id("com.codingfeline.buildkonfig").version("+")
}

android {
    namespace = Dependencies.Versions.MyProject.packageName
    compileSdk = Dependencies.Versions.MyProject.Android.compileSDK

    defaultConfig {
        minSdk = Dependencies.Versions.MyProject.Android.minSDK
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.composeCompilerExtension
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

            implementation(project.dependencies.platform(Dependencies.Libraries.Tweener.bom))
            implementation(Dependencies.Libraries.Tweener.common)
            implementation(Dependencies.Libraries.Tweener.firebase)
            implementation(Dependencies.Libraries.Tweener.charts)

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

            // Moko
            implementation(Dependencies.Libraries.Moko.compose)

            // Napier
            implementation(Dependencies.Libraries.napier)

            // Image fetcher
            implementation(Dependencies.Libraries.Coil.compose)
            implementation(Dependencies.Libraries.Coil.network)

            // Voyager
            implementation(Dependencies.Libraries.Voyager.tagNavigator)

            // Toast Compose
            implementation(Dependencies.Libraries.toastCompose)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // DI
            implementation(Dependencies.Libraries.Koin.android)

            // Compose
            implementation(compose.preview)
            implementation(compose.uiTooling)

            // Preferences
            implementation(Dependencies.Libraries.Android.AndroidX.preferences)
        }
    }
}

buildkonfig {
    packageName = Dependencies.Versions.MyProject.packageName

    // Release
    defaultConfigs {
        buildConfigField(BOOLEAN, "DEBUG", "false")
    }

    // Debug
    defaultConfigs("debug") {
        buildConfigField(BOOLEAN, "DEBUG", "true")
    }
}
