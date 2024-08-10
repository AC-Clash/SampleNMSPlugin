plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "1.7.2"
    id("io.github.goooler.shadow") version "8.1.8"
}

group = "com.acclash"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    mavenLocal()
    maven { url = uri("https://papermc.io/repo/repository/maven-public/") }
    maven { url = uri("https://papermc.io/repo/repository/maven-snapshots/") }
    maven { url = uri("https://hub.spigotmc.org/nexus/content/groups/public/") }
}

dependencies {
    paperweight.paperDevBundle("1.21-R0.1-SNAPSHOT")
}

java {
    // Configure the java toolchain. This allows gradle to auto-provision JDK 21 on systems that only have JDK 8 installed for example.
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    // Configure reobfJar to run when invoking the build task
    assemble {
        dependsOn(reobfJar)
    }

    compileJava {
        // Set the release flag. This configures what version bytecode the compiler will emit, as well as what JDK APIs are usable.
        // See https://openjdk.java.net/jeps/247 for more information.
        options.release.set(21)
    }

}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}
