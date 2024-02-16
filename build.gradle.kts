import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import java.io.StringWriter
import java.nio.file.Files
import java.nio.file.Paths

plugins {
    id("com.android.application").version(Dependencies.Versions.gradle).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    id("org.jetbrains.compose").version(Dependencies.Versions.composeMultiplatform).apply(false)
    kotlin("android").version(Dependencies.Versions.kotlin).apply(false)
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    kotlin("plugin.serialization").version(Dependencies.Versions.kotlin).apply(false)
    id("com.github.ben-manes.versions").version(Dependencies.Versions.dependencyVersionsPlugin) // ./gradlew dependencyUpdates
    id("com.google.gms.google-services").version(Dependencies.Versions.googleServicesPlugin).apply(false)
    id("com.google.firebase.crashlytics").version(Dependencies.Versions.crashlyticsPlugin).apply(false)
    id("com.google.firebase.firebase-perf").version(Dependencies.Versions.performancePlugin).apply(false)
    id("io.realm.kotlin").version(Dependencies.Versions.realm).apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// region Configure dependencyUpdates task

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        candidate.version.isNonStable()
    }

    outputFormatter {
        val reportFileDir = rootProject.buildDir.path + "/dependencyUpdates"
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
