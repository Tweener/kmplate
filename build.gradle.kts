plugins {
    //trick: for the same plugin versions in all sub-modules
    id("com.android.application").version(Dependencies.Versions.gradle).apply(false)
    id("com.android.library").version(Dependencies.Versions.gradle).apply(false)
    kotlin("android").version(Dependencies.Versions.kotlin).apply(false)
    kotlin("multiplatform").version(Dependencies.Versions.kotlin).apply(false)
    id("org.jetbrains.kotlin.jvm") version "1.8.20" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
