package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class Developer(
    val name: String
) : IDocument {

    companion object {

        val chengzis = Developer("cheng zis")

    }


    override fun generat(branch: Branch) {
        val element = branch.addElement("developer")
        element.addElement(::name.name).addText(name)
    }
}
