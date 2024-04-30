package com.github.chengzis.bom.utils

import com.github.chengzis.bom.pom.Project
import org.dom4j.DocumentHelper
import org.dom4j.io.OutputFormat
import org.dom4j.io.XMLWriter
import java.io.File
import java.io.FileOutputStream


fun Project.export() {
    val document = DocumentHelper.createDocument()
    build(document)

    val format = OutputFormat.createPrettyPrint()
    format.setIndent("    ")
    format.encoding = document.xmlEncoding


    val root = File("output")
    root.delete()
    val dir = File(File(root, groupId), artifactId)
    dir.mkdirs()
    dir.listFiles()?.forEach {
        it.delete()
    }
    val file = File(dir, "$version.pom")
    FileOutputStream(file).use {
        val writer = XMLWriter(it, format)
        writer.write(document)
        writer.flush()
        writer.close()
    }
}