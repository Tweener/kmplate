import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Dependencies.Versions.gradle).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    kotlin("android").version(Dependencies.Versions.kotlin).apply(false)
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    id("com.github.ben-manes.versions").version(Dependencies.Versions.gradleVersionsPlugin) // ./gradlew dependencyUpdates
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}

// region Configure dependencyUpdates task

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        candidate.version.isNonStable()
    }
}

fun String.isNonStable(): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { uppercase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(this)
    return isStable.not()
}

// endregion Configure dependencyUpdates task
