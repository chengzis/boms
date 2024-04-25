plugins {
    kotlin("jvm") version "1.9.23"
}

group = "com.github.chengzis.bom"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.dom4j:dom4j:2.1.4")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}