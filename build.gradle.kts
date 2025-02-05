import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import java.io.StringWriter
import java.nio.file.Files
import java.nio.file.Paths

plugins {
    alias(libs.plugins.android.application).apply(false)
    alias(libs.plugins.android.library).apply(false)
    alias(libs.plugins.jetbrains.compose).apply(false)
    alias(libs.plugins.jetbrains.compose.compiler).apply(false)
    alias(libs.plugins.kotlin.android).apply(false)
    alias(libs.plugins.kotlin.multiplatform).apply(false)
    alias(libs.plugins.kotlin.serialization).apply(false)
    alias(libs.plugins.dependency.versions) // ./gradlew dependencyUpdates
    alias(libs.plugins.google.services).apply(false)
    alias(libs.plugins.firebase.crashlytics).apply(false)
    alias(libs.plugins.firebase.performance).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

// region Configure dependencyUpdates task

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        candidate.version.isNonStable()
    }

    outputFormatter {
        val reportFileDir = rootProject.layout.buildDirectory.asFile.get().path + "/dependencyUpdates"
        Files.createDirectories(Paths.get(reportFileDir))
        val reportFile = File("$reportFileDir/report.txt").apply { writeText("") }

        // Outdated dependencies
        val outdated = this.outdated.dependencies
        if (outdated.isNotEmpty()) {
            val writer = StringWriter()
            writer.appendLine("The following dependencies have later milestone versions:")
            outdated.forEach { dependency ->
                writer.appendLine(" - ${dependency.group}:${dependency.name} [${dependency.version} -> ${dependency.available.milestone}]")
                writer.appendLine("     ${dependency.projectUrl}")
            }
            println(writer.toString())

            reportFile.appendText(writer.toString() + "\n\n")
        }

        // Unresolved dependencies (failed to determine the latest version)
        val unresolved = this.unresolved.dependencies
        if (unresolved.isNotEmpty()) {
            val writer = StringWriter()
            writer.appendLine("Failed to determine the latest version for the following dependencies:")
            unresolved.forEach { dependency ->
                writer.appendLine(" - ${dependency.group}:${dependency.name} -> ${dependency.version}")
            }
            println(writer.toString())

            reportFile.appendText(writer.toString() + "\n\n")
        }

        // Gradle
        val gradle = this.gradle
        val writer = StringWriter()
        writer.appendLine("Gradle release-candidate updates:")
        writer.appendLine(" - Gradle: [${gradle.running.version} -> ${gradle.current.version} -> ${gradle.releaseCandidate.version}]")
        println(writer.toString())

        reportFile.appendText(writer.toString())
    }
}

fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(this)
    return isStable.not()
}

// endregion Configure dependencyUpdates task
