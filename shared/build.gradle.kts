import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.BOOLEAN

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
    alias(libs.plugins.buildkonfig)
}

android {
    namespace = ProjectConfiguration.MyProject.packageName
    compileSdk = ProjectConfiguration.MyProject.Android.compileSDK

    defaultConfig {
        minSdk = ProjectConfiguration.MyProject.Android.minSDK
    }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility
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

            export(libs.tweener.passage)
        }
    }

    // endregion iOS configuration

    sourceSets {
        commonMain.dependencies {
            api(project(":shared:data"))
            api(project(":shared:domain"))
            api(project(":shared:presentation"))

            implementation(libs.kotlin.coroutines.core)

            // Tweener
            implementation(libs.tweener.czan)
            implementation(libs.tweener.passage)
            implementation(libs.tweener.kmpkit)

            implementation(project.dependencies.platform(libs.tweener.bom))
            implementation(libs.tweener.firebase)
            implementation(libs.tweener.alarmee)

            // DI
            implementation(libs.koin.core)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // DI
            implementation(libs.koin.android)

            // Preferences
            implementation(libs.android.preferences)
        }
    }
}

buildkonfig {
    packageName = ProjectConfiguration.MyProject.packageName

    // Release
    defaultConfigs {
        buildConfigField(BOOLEAN, "DEBUG", "false")
    }

    // Debug
    defaultConfigs("debug") {
        buildConfigField(BOOLEAN, "DEBUG", "true")
    }
}
