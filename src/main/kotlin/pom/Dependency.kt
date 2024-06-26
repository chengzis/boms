package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class Dependency(
    val groupId: String,
    val artifactId: String,
    val version: String
) : IDocument {
    override fun generat(branch: Branch) {
        branch.addElement(::groupId.name).addText(groupId)
        branch.addElement(::artifactId.name).addText(artifactId)
        branch.addElement(::version.name).addText(version)
    }
}