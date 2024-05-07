package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class PluginManagement(
    val plugins: List<Dependency>
) : IDocument {

    override fun generat(branch: Branch) {
        val element = branch.addElement("plugins")
        plugins.forEach {
            it.generat(element.addElement("plugin"))
        }
    }
}