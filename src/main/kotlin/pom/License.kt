package com.github.chengzis.bom.pom

import org.dom4j.Branch


data class License(
    val name: String,
    val url: String,
    val distribution: String
) : IDocument {

    companion object {

        val Apache = License(
            name = "The Apache Software License, Version 2.0",
            url = "https://www.apache.org/licenses/LICENSE-2.0.txt",
            distribution = "repo"
        )


    }


    override fun generat(branch: Branch) {
        val element = branch.addElement("license")
        element.addElement(::name.name).addText(name)
        element.addElement(::url.name).addText(url)
        element.addElement(::distribution.name).addText(distribution)
    }
}