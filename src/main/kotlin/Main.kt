package com.github.chengzis.bom

import com.github.chengzis.bom.version.AndroidSdkVersion
import org.dom4j.DocumentHelper
import org.dom4j.io.OutputFormat
import org.dom4j.io.XMLWriter
import java.io.File
import java.io.FileOutputStream


fun main() {
    generateAndroidx(AndroidSdkVersion.P, "1.0.0")
    generateAndroidx(AndroidSdkVersion.S, "1.0.0")
    generateAndroidx(AndroidSdkVersion.S_V2, "1.0.0")
    generateAndroidx(AndroidSdkVersion.TIRAMISU, "1.0.0")
    generateAndroidx(AndroidSdkVersion.UPSIDE_DOWN_CAKE, "1.0.0")
}

private fun generateAndroidx(sdkVersion: AndroidSdkVersion, moduleVersion: String) {
    val project = Androidx.build(sdkVersion, moduleVersion)
    val document = DocumentHelper.createDocument()
    project.build(document)

    val format = OutputFormat.createPrettyPrint()
    format.setIndent("    ")
    format.encoding = document.xmlEncoding


    val dir = File("output")
    dir.mkdirs()
    val file = File(dir, "${project.artifactId}-${project.version}.pom")
    val out = FileOutputStream(file)
    val writer = XMLWriter(out, format)
    writer.write(document)
    writer.flush()
    writer.close()

    out.close()
}