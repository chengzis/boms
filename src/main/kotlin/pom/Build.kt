package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class Build(
    val pluginManagement: PluginManagement
) : IDocument {

    override fun generat(branch: Branch) {
        pluginManagement.generat(branch.addElement(::pluginManagement.name))
    }
}