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
                const val applicationId = packageName
                const val namespace = "$packageName.android"
                const val compileSDK = 34
                const val targetSDK = compileSDK
                const val minSDK = 24
                const val versionCode = 1
            }
        }

        object Compiler {
            const val jvmTarget = "17"
            val javaCompatibility = JavaVersion.VERSION_17
        }

        const val kotlin = "1.9.22"
        const val gradle = "8.2.2"
        const val composeMultiplatform = "1.6.0-rc01"
        const val coroutines = "1.7.3"
        const val kodein = "7.21.2"
        const val ktor = "2.3.8"
        const val napier = "2.7.1"
        const val realm = "1.13.0"
        const val kotlinxDatetime = "0.4.1"
        const val dependencyVersionsPlugin = "0.51.0"
        const val googleServicesPlugin = "4.4.0"
        const val crashlyticsPlugin = "2.9.9"
        const val performancePlugin = "1.4.2"
        const val firebase = "1.11.1" // Firebase for KMP https://firebaseopensource.com/projects/gitliveapp/firebase-kotlin-sdk/
        const val coil = "3.0.0-alpha01"

        object Tweener {
            const val czan = "2.0.1"
            const val common = "1.0.2"
            const val realm = "1.0.1"
            const val firebase = "1.0.1"
        }

        object Android {
            const val firebase = "32.7.1"
            const val composeCompilerExtension = "1.5.9" // See mapping with Kotlin version here: https://developer.android.com/jetpack/androidx/releases/compose-kotlin
            const val activityCompose = "1.8.2"
            const val desugarJdkLibs = "2.0.4"
            const val accompanist = "0.34.0"
            const val adMob = "22.6.0"

            object AndroidX {
                const val activity = "1.8.2"
                const val splashscreen = "1.0.1"
            }
        }
    }

    object Libraries {

        const val napier = "io.github.aakira:napier:${Versions.napier}"
        const val kotlinXDatetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.kotlinxDatetime}"

        object Tweener {
            const val czan = "io.github.tweener:czan:${Versions.Tweener.czan}"
            const val common = "io.github.tweener:kmp-common:${Versions.Tweener.common}"
            const val realm = "io.github.tweener:kmp-realm:${Versions.Tweener.realm}"
            const val firebase = "io.github.tweener:kmp-firebase:${Versions.Tweener.firebase}"
        }

        object ComposeMultiplatform {
            const val material3 = "org.jetbrains.compose.material3:material3:${Versions.composeMultiplatform}"
        }

        object Coil {
            const val compose = "io.coil-kt.coil3:coil-compose:${Versions.coil}"
            const val network = "io.coil-kt.coil3:coil-network:${Versions.coil}"
        }

        object Kodein {
            const val core = "org.kodein.di:kodein-di:${Versions.kodein}"
            const val compose = "org.kodein.di:kodein-di-framework-compose:${Versions.kodein}"
        }

        object Coroutines {
            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
            const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        }

        object Ktor {
            const val serializationJson = "io.ktor:ktor-serialization-kotlinx-json:${Versions.ktor}"

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
        }

        object Android {
            const val desugarJdkLibs = "com.android.tools:desugar_jdk_libs:${Versions.Android.desugarJdkLibs}"
            const val adMob = "com.google.android.gms:play-services-ads:${Versions.Android.adMob}"

            object Firebase {
                const val bom = "com.google.firebase:firebase-bom:${Versions.Android.firebase}"
                const val analytics = "com.google.firebase:firebase-analytics-ktx"
                const val performance = "com.google.firebase:firebase-perf-ktx"
            }

            object AndroidX {
                const val activity = "androidx.activity:activity-ktx:${Versions.Android.AndroidX.activity}"
                const val splashscreen = "androidx.core:core-splashscreen:${Versions.Android.AndroidX.splashscreen}"

                object Compose {
                    const val activity = "androidx.activity:activity-compose:${Versions.Android.activityCompose}"
                }
            }

            object Accompanist {
                const val permissions = "com.google.accompanist:accompanist-permissions:${Versions.Android.accompanist}"
            }
        }
    }
}
