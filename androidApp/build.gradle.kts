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

    // Android
    implementation(Dependencies.Libraries.Tweener.Android.common)
    implementation(Dependencies.Libraries.Tweener.Android.cezanne)
    implementation(Dependencies.Libraries.Tweener.Android.placeholder)

    // Android
    implementation(Dependencies.Libraries.Android.AndroidX.material3)
    implementation(Dependencies.Libraries.Android.AndroidX.splashscreen)
    implementation(Dependencies.Libraries.Android.AndroidX.activity)
    implementation(Dependencies.Libraries.Android.Accompanist.systemUIController)
    implementation(Dependencies.Libraries.Android.Accompanist.permissions)
    implementation(Dependencies.Libraries.Android.adMob)

    // Compose
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.ui)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.uiTooling)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.uiToolingPreview)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.foundation)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.material)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.materialIconsCore)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.materialIconsExtended)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.activity)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.navigation)
    implementation(Dependencies.Libraries.Android.AndroidX.Compose.lifecycleRuntime)

    // Firebase
    implementation(platform(Dependencies.Libraries.Firebase.bom))
    implementation(Dependencies.Libraries.Firebase.analytics)
    implementation(Dependencies.Libraries.Firebase.crashlytics)
    implementation(Dependencies.Libraries.Firebase.performance)

    // Coroutines
    implementation(Dependencies.Libraries.Coroutines.core)
    implementation(Dependencies.Libraries.Coroutines.android)

    // DI
    implementation(Dependencies.Libraries.Kodein.viewModel)
    implementation(Dependencies.Libraries.Kodein.compose)

    // Napier
    implementation(Dependencies.Libraries.napier)

    // Image fetcher
    implementation(Dependencies.Libraries.Android.glide)
    implementation(Dependencies.Libraries.Android.glidePlaceholder)
}
