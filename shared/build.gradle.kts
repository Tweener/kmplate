plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.android.library")
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

@OptIn(org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi::class)
kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()

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

        ios.deploymentTarget = Dependencies.Versions.MyProject.IOS.deploymentTarget
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"

            // Add here any extra framework dependencies
            export(project(":shared:data"))
            export(project(":shared:domain"))
        }
    }

    // endregion iOS configuration

    sourceSets {
        commonMain.dependencies {
            api(project(":shared:data"))
            api(project(":shared:domain"))
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
