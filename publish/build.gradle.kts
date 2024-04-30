import groovy.util.Node
import org.dom4j.Element
import org.dom4j.io.SAXReader

plugins {
    kotlin("jvm")
    id("com.vanniktech.maven.publish") version "0.28.0"
}

group = "io.github.chengzis"

repositories {
    mavenCentral()
}

publishing {
    publications {
        File(rootProject.projectDir, "output").listFiles()?.forEach { group ->
            group.listFiles()?.forEach { artifact ->
                val version = artifact.listFiles()?.firstOrNull()
                if (version != null) {
                    create("${group.name}${artifact.name}", MavenPublication::class.java) {

                        groupId = group.name
                        artifactId = artifact.name
                        setVersion(version.nameWithoutExtension)
                        pom {
                            withXml {
                                val project = asNode()

                                val children = project.children().toList()
                                children.forEach {
                                    project.remove(it as Node)
                                }

                                val reader = SAXReader()
                                val document = reader.read(version)

                                document.rootElement.elements().forEach {
                                    copyXml(it, project)
                                }
                            }
                        }
                    }
                }
            }
        }

    }
}


fun copyXml(src: Element, parent: Node) {
    val attributes = src.attributes().associate { it.name to it.value }.ifEmpty { null }

    val value = src.text.ifEmpty { null }
    val dest = parent.appendNode(src.name, attributes, value)

    src.elements().forEach {
        copyXml(it, dest)
    }
}
