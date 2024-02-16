plugins {
    id("com.android.application")
    kotlin("android")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("com.google.firebase.firebase-perf")
}

android {
    namespace = Dependencies.Versions.MyProject.Android.namespace
    compileSdk = Dependencies.Versions.MyProject.Android.compileSDK

    defaultConfig {
        applicationId = Dependencies.Versions.MyProject.Android.applicationId
        minSdk = Dependencies.Versions.MyProject.Android.minSDK
        targetSdk = Dependencies.Versions.MyProject.Android.targetSDK
        versionCode = Dependencies.Versions.MyProject.Android.versionCode
        versionName = Dependencies.Versions.MyProject.versionName
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.Android.composeCompilerExtension
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
        sourceCompatibility = Dependencies.Versions.Compiler.javaCompatibility
        targetCompatibility = Dependencies.Versions.Compiler.javaCompatibility

        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = Dependencies.Versions.Compiler.jvmTarget
    }
}

dependencies {
    implementation(project(":shared"))

    coreLibraryDesugaring(Dependencies.Libraries.Android.desugarJdkLibs)

    // Tweener
    implementation(Dependencies.Libraries.Tweener.czan)

    // Android
    implementation(Dependencies.Libraries.Android.AndroidX.splashscreen)
    implementation(Dependencies.Libraries.Android.AndroidX.activity)
    implementation(Dependencies.Libraries.Android.Accompanist.permissions)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.activity)
    implementation(Dependencies.Libraries.Android.adMob)

    // Firebase
    implementation(platform(Dependencies.Libraries.Android.Firebase.bom))
    implementation(Dependencies.Libraries.Android.Firebase.analytics)
    implementation(Dependencies.Libraries.Android.Firebase.performance)

    // DI
    implementation(Dependencies.Libraries.Koin.core)
    implementation(Dependencies.Libraries.Koin.android)
}
