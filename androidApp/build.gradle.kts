plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "com.tweener.kmmtemplate.android"
    compileSdk = Dependencies.Versions.Tropse.Android.compileSDK

    defaultConfig {
        applicationId = Dependencies.Versions.Tropse.packageName + ".android"
        minSdk = Dependencies.Versions.Tropse.Android.minSDK
        targetSdk = Dependencies.Versions.Tropse.Android.targetSDK
        versionCode = Dependencies.Versions.Tropse.Android.versionCode
        versionName = Dependencies.Versions.Tropse.versionName
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        isCoreLibraryDesugaringEnabled = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
