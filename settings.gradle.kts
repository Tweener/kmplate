pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
        mavenLocal()
    }
}

rootProject.name = "Kmplate" // TODO Change this to your project name
include(":androidApp")
include(":shared")
include(":shared:data")
include(":shared:domain")
include(":shared:presentation")
