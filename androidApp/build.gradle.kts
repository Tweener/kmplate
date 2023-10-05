plugins {
    id("com.android.application")
    kotlin("android")
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
