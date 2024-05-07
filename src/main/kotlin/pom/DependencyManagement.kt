package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class DependencyManagement(
    val dependencies: List<Dependency>
) : IDocument {

    override fun generat(branch: Branch) {
        val element = branch.addElement("dependencies")
        dependencies.forEach {
            it.generat(element.addElement("dependency"))
        }
    }
}