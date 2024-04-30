import groovy.util.Node
import org.dom4j.Element
import org.dom4j.io.SAXReader

plugins {
    kotlin("jvm") version "1.9.23"
    id("com.vanniktech.maven.publish") version "0.28.0"
}

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

group = "io.github.chengzis"



//
//
//File(rootProject.projectDir, "output").listFiles()?.forEach { artifact ->
//    val version = artifact.listFiles()?.firstOrNull()
//    if (version != null) {
//
//
//
//        mavenPublishing {
//
//
//
//        }
//    }
//}
