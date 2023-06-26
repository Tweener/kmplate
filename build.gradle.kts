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
