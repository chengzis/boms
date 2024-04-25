package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class Dependency(
    val groupId: String,
    val artifactId: String,
    val version: String
) : IDocument {
    override fun build(branch: Branch) {
        val element = branch.addElement("dependency")
        element.addElement(::groupId.name).addText(groupId)
        element.addElement(::artifactId.name).addText(artifactId)
        element.addElement(::version.name).addText(version)
    }
}