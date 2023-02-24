plugins {
    id("java")
    kotlin("jvm") version "1.8.0"
}

group = "fr.uge.tp3"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.blazegraph:bigdata-core:2.1.4")
    implementation("com.blazegraph:bigdata-client:2.1.4")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}