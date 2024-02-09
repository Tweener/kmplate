pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { setUrl("https://jitpack.io") }
        mavenLocal()
    }
}

rootProject.name = "Kmplate" // TODO Change this to your project name
include(":androidApp")
include(":shared")
include(":shared:data")
include(":shared:domain")
include(":shared:presentation")
