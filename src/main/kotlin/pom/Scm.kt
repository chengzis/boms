package com.github.chengzis.bom.pom

import org.dom4j.Branch

data class Scm(
    val connection: String,
    val developerConnection: String,
    val url: String,
) : IDocument {

    companion object {

        val boms = build("github.com/chengzis/boms")

        fun build(url: String): Scm {

            return Scm(
                connection = "scm:git:https://${url}.git",
                developerConnection = "scm:git:ssh://git@${url}.git",
                url = "https://$url"
            )
        }

    }

    override fun generat(branch: Branch) {
        branch.addElement(::connection.name).addText(connection)
        branch.addElement(::developerConnection.name).addText(developerConnection)
        branch.addElement(::url.name).addText(url)
    }
}