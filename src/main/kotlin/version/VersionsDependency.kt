package com.github.chengzis.bom.version

import com.github.chengzis.bom.pom.Dependency

interface IVersionsDependency {

    val groupId: String
    val artifactId: String
    val versions: List<Version>

}

fun IVersionsDependency.copy(
    groupId: String = this.groupId,
    artifactId: String = this.artifactId,
    versions: List<Version> = this.versions
): VersionsDependency {
    return VersionsDependency(groupId, artifactId, versions)
}

fun IVersionsDependency.subArtifact(
    subArtifactId: String,
    separator: String = "-",
    versions: List<Version> = this.versions
): VersionsDependency =
    copy(artifactId = "${artifactId}${separator}$subArtifactId", versions = versions)

open class VersionsDependency(
    override val groupId: String,
    override val artifactId: String,
    override val versions: List<Version>
) : IVersionsDependency

abstract class VersionsDependencyGroup(
    override val groupId: String,
    override val artifactId: String,
    override val versions: List<Version>
) : IVersionsDependency


fun VersionsDependency.build(sdkVersion: AndroidSdkVersion): Dependency? {
    val version = versions.filter { it.minSdk <= sdkVersion }.maxByOrNull { it.version }
    if (version == null) {
        return null
    }
    return Dependency(
        groupId = groupId,
        artifactId = artifactId,
        version = version.version
    )
}


interface IComposeDependencies : IVersionsDependency {

    val compose get() = subArtifact("compose")

}

interface IKtxDependencies : IVersionsDependency {

    val ktx get() = subArtifact("ktx")

}

interface ICompilerDependencies : IComposeDependencies {

    val compiler get() = subArtifact("compiler")

}

interface ITestingDependencies : IComposeDependencies {

    val testing get() = subArtifact("testing")

}

interface ITestDependencies : IComposeDependencies {

    val test get() = subArtifact("test")

}
