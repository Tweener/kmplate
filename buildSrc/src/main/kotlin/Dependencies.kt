import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object Dependencies {

    object Versions {

        // TODO Rename MyProject to your project name
        object MyProject {
            const val packageName = "com.tweener.changehere" // TODO Change this
            const val versionName = "1.0"

            object Android {
                const val applicationId = MyProject.packageName
                const val namespace = MyProject.packageName + ".android"
                const val compileSDK = 33
                const val targetSDK = compileSDK
                const val minSDK = 24
                const val versionCode = 1
            }

            object IOS {
                const val deploymentTarget = "14.1"
            }
        }

        object Compiler {
            const val jvmTarget = "17"
            val javaCompatibility = JavaVersion.VERSION_17
        }

        const val jvmTarget = "17"
        const val kotlin = "1.8.21"
        const val gradle = "8.0.2"
        const val coroutines = "1.6.3-native-mt"
        const val kodein = "7.20.2"
        const val ktor = "2.3.2"
        const val napier = "2.6.1"
        const val kotlinxDatetime = "0.4.0"
        const val gradleVersionsPlugin = "0.47.0"

        object Android {
            const val composeCompilerExtension = "1.4.8"
            const val compose = "1.4.3"
            const val activityCompose = "1.7.2"
            const val navigationCompose = "2.6.0"
            const val material3 = "1.1.0"
            const val loggingInterceptor = "3.1.0"
            const val glide = "2.2.2"
            const val desugarJdkLibs = "2.0.3"
            const val accompanist = "0.30.1"

            object AndroidX {
                const val appcompat = "1.4.2"
                const val constraintlayout = "2.1.4"
                const val lifecycle = "2.6.1"
                const val splashscreen = "1.0.0-rc01"
            }
        }
    }

    object Libraries {

        const val napier = "io.github.aakira:napier:${Versions.napier}"
        const val kotlinXDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDatetime}"

        object Kodein {
            const val core = "org.kodein.di:kodein-di:${Versions.kodein}"
            const val viewModel = "org.kodein.di:kodein-di-framework-android-x-viewmodel:${Versions.kodein}"
            const val compose = "org.kodein.di:kodein-di-framework-compose:${Versions.kodein}"
        }

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }

        object Ktor {
            object Client {
                const val core = "io.ktor:ktor-client-core:${Versions.ktor}"
                const val auth = "io.ktor:ktor-client-auth:${Versions.ktor}"
                const val contentNegotiation = "io.ktor:ktor-client-content-negotiation:${Versions.ktor}"
                const val logging = "io.ktor:ktor-client-logging:${Versions.ktor}"

                object Android {
                    const val okhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
                }

                object iOS {
                    const val client = "io.ktor:ktor-client-ios:${Versions.ktor}"
                }
            }

            const val serializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"
        }

        object Android {
            const val material3 = "androidx.compose.material3:material3:${Versions.Android.material3}"
            const val loggingInterceptor = "com.github.ihsanbal:LoggingInterceptor:${Versions.Android.loggingInterceptor}"
            const val glide = "com.github.skydoves:landscapist-glide:${Versions.Android.glide}"
            const val glidePlaceholder = "com.github.skydoves:landscapist-placeholder:${Versions.Android.glide}"
            const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.Android.desugarJdkLibs}"

            object AndroidX {
                const val appcompat = "androidx.appcompat:appcompat:${Versions.Android.AndroidX.appcompat}"
                const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.Android.AndroidX.constraintlayout}"
                const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Android.AndroidX.lifecycle}"
                const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.Android.AndroidX.lifecycle}"
                const val splashscreen = "androidx.core:core-splashscreen:${Versions.Android.AndroidX.splashscreen}"

                object Compose {
                    const val ui = "androidx.compose.ui:ui:${Versions.Android.compose}"
                    const val uiTooling = "androidx.compose.ui:ui-tooling:${Versions.Android.compose}"
                    const val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:${Versions.Android.compose}"
                    const val foundation = "androidx.compose.foundation:foundation:${Versions.Android.compose}"
                    const val material = "androidx.compose.material:material:${Versions.Android.compose}"
                    const val materialIconsCore = "androidx.compose.material:material-icons-core:${Versions.Android.compose}"
                    const val materialIconsExtended = "androidx.compose.material:material-icons-extended:${Versions.Android.compose}"
                    const val activity = "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
                    const val navigation = "androidx.navigation:navigation-compose:${Versions.Android.navigationCompose}"
                    const val lifecycleRuntime = "androidx.lifecycle:lifecycle-runtime-compose:${Versions.Android.AndroidX.lifecycle}"
                }
            }

            object Accompanist {
                const val systemUIController = "com.google.accompanist:accompanist-systemuicontroller:${Versions.Android.accompanist}"
                const val placeholder = "com.google.accompanist:accompanist-placeholder:${Versions.Android.accompanist}"
                const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.Android.accompanist}"
            }
        }
    }
}
