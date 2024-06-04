pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        mavenLocal()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "Kmplate" // TODO Change this to your project name
include(":androidApp")
include(":shared")
include(":shared:data")
include(":shared:domain")
include(":shared:presentation")
