plugins {
    java
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.1.0"
}

group = "com.github.imalwayscoding"
version = "1.0"

repositories {
    mavenCentral()

    // paper
    maven("https://papermc.io/repo/repository/maven-public/")

    // jitpack
    maven("https://jitpack.io/")
}

dependencies {
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")

    // paper
    compileOnly("com.destroystokyo.paper:paper-api:1.16.4-R0.1-SNAPSHOT")

    // kommand
    implementation("com.github.noonmaru:kommand:0.6.4")
}

tasks {
    shadowJar {
        archiveBaseName.set("Rank")
        archiveVersion.set("")
        archiveClassifier.set("")
    }
}
