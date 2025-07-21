pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "honey"
include(":app")
include(":modules:core")
include(":modules:data")
include(":modules:domain")
include(":modules:feature-auth")
include(":modules:feature-market")
include(":modules:feature-order")
include(":modules:feature-beekeeper")
include(":modules:feature-profile")
 