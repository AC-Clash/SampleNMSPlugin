rootProject.name = "SampleNMSPlugin"

pluginManagement {
    repositories {
        //mavenLocal()
        gradlePluginPortal()
        maven {
            url = uri("https://papermc.io/repo/repository/maven-public/")
        }
        maven {
            url = uri("https://papermc.io/repo/repository/maven-snapshots/")
        }
    }
}
