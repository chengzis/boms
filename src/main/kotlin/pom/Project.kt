package com.github.chengzis.bom.pom

import org.dom4j.Branch


data class Project(
    val modelVersion: String = "4.0.0",
    val groupId: String = "io.github.chengzis",
    val artifactId: String,
    val version: String,
    val packaging: String = "pom",
    val name: String = artifactId,
    val description: String,
    val url: String = "https://github.com/chengzis/boms/",
    val licenses: List<License> = listOf(License.Apache),
    val developers: List<Developer> = listOf(Developer.chengzis),
    val scm: Scm = Scm.boms,
    val dependencyManagement: DependencyManagement,
) : IDocument {

    override fun build(branch: Branch) {
        val element = branch.addElement("project")

        element.addAttribute("xmlns", "http://maven.apache.org/POM/4.0.0")
        element.addAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance")
        element.addAttribute("xsi:schemaLocation", "http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd")

        element.addElement(::modelVersion.name).addText(modelVersion)
        element.addElement(::groupId.name).addText(groupId)
        element.addElement(::artifactId.name).addText(artifactId)
        element.addElement(::version.name).addText(version)
        element.addElement(::packaging.name).addText(packaging)
        element.addElement(::name.name).addText(name)
        element.addElement(::description.name).addText(description)
        element.addElement(::url.name).addText(url)

        element.addElement(::licenses.name).apply {
            licenses.forEach {
                it.build(this)
            }
        }

        element.addElement(::developers.name).apply {
            developers.forEach {
                it.build(this)
            }
        }

        element.addElement(::scm.name).apply {
            scm.build(this)
        }

        element.addElement(::dependencyManagement.name).apply {
            dependencyManagement.build(this)
        }
    }
}