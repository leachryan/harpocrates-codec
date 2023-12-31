plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.7.10"

    // Apply the java-library plugin for API and implementation separation.
    `java-library`

    // Add the maven publishing plugin
    `maven-publish`
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")

    // Use the JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.9.1")

    // This dependency is exported to consumers, that is to say found on their compile classpath.
    api("org.apache.commons:commons-math3:3.6.1")

    // This dependency is used internally, and not exposed to consumers on their own compile classpath.
    implementation("com.google.guava:guava:31.1-jre")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/leachryan/harpocrates-codec")
            credentials {
                username = (project.findProperty("gpr.user") ?: System.getenv("GITHUB_USERNAME")).toString()
                password = (project.findProperty("gpr.key") ?: System.getenv("GITHUB_TOKEN")).toString()
            }
        }
    }
    publications {
        register<MavenPublication>("gpr") {
            groupId = "dev.leachryan"
            artifactId = "harpocrates-codec"
            version = "0.0.1"
            from(components["java"])
        }
    }
}

version = "0.0.1"
