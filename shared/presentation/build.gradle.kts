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
}

kotlin {
    applyDefaultHierarchyTemplate()

    androidTarget()

    iosX64()
    iosArm64()
    iosSimulatorArm64()

    sourceSets {
        commonMain.dependencies {
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }
    }
}
