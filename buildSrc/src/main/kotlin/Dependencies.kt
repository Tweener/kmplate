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
                const val compileSDK = 34
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

        const val kotlin = "1.9.10"
        const val gradle = "8.1.2"
        const val coroutines = "1.7.3"
        const val kodein = "7.20.2"
        const val ktor = "2.3.4"
        const val napier = "2.6.1"
        const val kotlinxDatetime = "0.4.1"
        const val gradleVersionsPlugin = "0.49.0"
        const val googleServicesPlugin = "4.3.15"
        const val crashlyticsPlugin = "2.9.9"
        const val performancePlugin = "1.4.2"
        const val firebase = "32.2.3"

        object Tweener {
            object Android {
                const val common = "2.0.3"
                const val cezanne = "1.0.4"
                const val placeholder = "1.0.0"
            }
        }

        object Android {
            const val composeCompilerExtension = "1.5.3"
            const val compose = "1.6.0-alpha08"
            const val activityCompose = "1.8.0"
            const val navigationCompose = "2.7.4"
            const val material3 = "1.1.1"
            const val loggingInterceptor = "3.1.0"
            const val glide = "2.2.8"
            const val desugarJdkLibs = "2.0.3"
            const val accompanist = "0.32.0"
            const val adMob = "22.4.0"

            object AndroidX {
                const val activity = "1.8.0-alpha07"
                const val appcompat = "1.4.2"
                const val constraintlayout = "2.1.4"
                const val lifecycle = "2.6.2"
                const val splashscreen = "1.0.1"
            }
        }
    }

    object Libraries {

        const val napier = "io.github.aakira:napier:${Versions.napier}"
        const val kotlinXDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDatetime}"

        object Tweener {
            object Android {
                const val common = "com.github.Tweener:common-android:${Versions.Tweener.Android.common}"
                const val cezanne = "com.github.Tweener:cezanne-android:${Versions.Tweener.Android.cezanne}"
                const val placeholder = "com.github.Tweener:placeholder-material3:${Versions.Tweener.Android.placeholder}"
            }
        }

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

        object Firebase {
            const val bom = "com.google.firebase:firebase-bom:${Versions.firebase}"
            const val analytics = "com.google.firebase:firebase-analytics-ktx"
            const val crashlytics = "com.google.firebase:firebase-crashlytics-ktx"
            const val performance = "com.google.firebase:firebase-perf-ktx"
        }

        object Android {
            const val material3 = "androidx.compose.material3:material3:${Versions.Android.material3}"
            const val loggingInterceptor = "com.github.ihsanbal:LoggingInterceptor:${Versions.Android.loggingInterceptor}"
            const val glide = "com.github.skydoves:landscapist-glide:${Versions.Android.glide}"
            const val glidePlaceholder = "com.github.skydoves:landscapist-placeholder:${Versions.Android.glide}"
            const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.Android.desugarJdkLibs}"
            const val adMob = "com.google.android.gms:play-services-ads:${Versions.Android.adMob}"

            object AndroidX {
                const val material3 = "androidx.compose.material3:material3:${Versions.Android.material3}"
                const val activity = "androidx.activity:activity-ktx:${Versions.Android.AndroidX.activity}"
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
                const val navigationAnimation = "com.google.accompanist:accompanist-navigation-animation:${Versions.Android.accompanist}"
                const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.Android.accompanist}"
            }
        }
    }
}
