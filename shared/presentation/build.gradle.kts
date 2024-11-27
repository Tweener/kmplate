plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.compose)
    alias(libs.plugins.jetbrains.compose.compiler)
}

android {
    namespace = ProjectConfiguration.MyProject.packageName + ".presentation"
    compileSdk = ProjectConfiguration.MyProject.Android.compileSDK

    defaultConfig {
        minSdk = ProjectConfiguration.MyProject.Android.minSDK
    }

    compileOptions {
        sourceCompatibility = ProjectConfiguration.Compiler.javaCompatibility
        targetCompatibility = ProjectConfiguration.Compiler.javaCompatibility
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
            api(project(":shared:domain"))

            // Tweener
            implementation(libs.tweener.czan)

            implementation(project.dependencies.platform(libs.tweener.bom))
            implementation(libs.tweener.common)
            implementation(libs.tweener.realm)
            implementation(libs.tweener.firebase)

            // Compose
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)
            implementation(libs.compose.multiplatform.material3)

            // DI
            implementation(libs.koin.core)
            implementation(libs.koin.compose)
            implementation(libs.koin.compose.viewmodel)

            // ViewModel
            implementation(libs.jetbrains.lifecycle.viewmodel.compose)
            implementation(libs.jetbrains.lifecycle.runtime.compose)

            // Moko
            implementation(libs.moko.permissions)

            // Napier
            implementation(libs.napier)

            // Coil (Image fetcher)
            implementation(libs.bundles.coil)

            // Voyager
            implementation(libs.voyager.tab.navigator)

            // Toast Compose
            implementation(libs.toast.compose)
        }

        commonTest.dependencies {
            implementation(kotlin("test"))
        }

        androidMain.dependencies {
            // DI
            implementation(libs.koin.android)

            // Compose
            implementation(compose.preview)
            implementation(compose.uiTooling)

            // Preferences
            implementation(libs.android.preferences)
        }
    }
}
