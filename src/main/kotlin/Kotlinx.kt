package com.github.chengzis.bom

import com.github.chengzis.bom.version.ITestDependencies
import com.github.chengzis.bom.version.VersionsDependencyGroup

object Kotlinx : IExportArtifact {

    object Coroutines : VersionsDependencyGroup(
        groupId = "org.jetbrains.kotlinx",
        artifactId = "kotlinx-coroutines",
        versions = listOf(

        )
    ), ITestDependencies

    override fun export() {

    }
}