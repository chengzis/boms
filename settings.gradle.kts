plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

buildscript {
    dependencies {
        classpath("org.dom4j:dom4j:2.1.4")
    }
}
rootProject.name = "boms"
