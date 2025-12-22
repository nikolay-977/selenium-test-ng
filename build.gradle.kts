plugins {
    id("java")
}

group = "ru.skillfactory"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.39.0")
    implementation("io.github.bonigarcia:webdrivermanager:6.3.3")
    testImplementation("org.testng:testng:7.11.0")
}


tasks.withType<Test> {
    useTestNG()
}