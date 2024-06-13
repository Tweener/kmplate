plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.services)
    alias(libs.plugins.firebase.crashlytics)
    alias(libs.plugins.firebase.performance)
    alias(libs.plugins.jetbrains.compose.compiler)
}

android {
    namespace = ProjectConfiguration.MyProject.Android.namespace
    compileSdk = ProjectConfiguration.MyProject.Android.compileSDK

    defaultConfig {
        applicationId = ProjectConfiguration.MyProject.Android.applicationId
        minSdk = ProjectConfiguration.MyProject.Android.minSDK
        targetSdk = ProjectConfiguration.MyProject.Android.targetSDK
        versionCode = ProjectConfiguration.MyProject.Android.versionCode
        versionName = ProjectConfiguration.MyProject.versionName
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isDebuggable = true
        }
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility

        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = ProjectConfiguration.Compiler.jvmTarget
    }
}

dependencies {
    implementation(project(":shared"))

    coreLibraryDesugaring(libs.android.desugarjdklibs)

    // Tweener
    implementation(libs.tweener.czan)

    // Android
    implementation(libs.android.splashscreen)
    implementation(libs.android.activity)
    implementation(libs.android.activity.compose)
    implementation(libs.android.accompanist.permissions)
    implementation(libs.android.admob)

    // Firebase
    implementation(platform(libs.android.firebase.bom))
    implementation(libs.android.firebase.analytics)
    implementation(libs.android.firebase.performance)

    // DI
    implementation(libs.koin.core)
    implementation(libs.koin.android)
}
