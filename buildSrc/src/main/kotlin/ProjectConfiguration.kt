import org.gradle.api.JavaVersion

/**
 * @author Vivien Mahe
 * @since 23/07/2022
 */

object ProjectConfiguration {

    // TODO Rename MyProject to your project name
    object MyProject {
        const val packageName = "com.tweener.changehere" // TODO Change this
        const val versionName = "1.0"

        object Android {
            const val applicationId = packageName
            const val namespace = "$packageName.android"
            const val compileSDK = 35
            const val targetSDK = compileSDK
            const val minSDK = 24
            const val versionCode = 1
        }
    }

    object Compiler {
        val javaCompatibility = JavaVersion.VERSION_21
        val jvmTarget = javaCompatibility.toString()
    }
}
