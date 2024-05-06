package com.github.chengzis.bom.version

import com.github.chengzis.bom.pom.Dependency

open class VersionsDependency(
    val groupId: String,
    val artifactId: String,
    val versions: List<Version>
) {

    fun copy(
        groupId: String = this.groupId,
        artifactId: String = this.artifactId,
        versions: List<Version> = this.versions
    ): VersionsDependency {
        return VersionsDependency(groupId, artifactId, versions)
    }

    fun subArtifact(subArtifactId: String, separator: String = "-", versions: List<Version> = this.versions): VersionsDependency =
        copy(artifactId = "${artifactId}${separator}$subArtifactId", versions = versions)

}


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


interface IComposeDependencies

interface IKtxDependencies

interface ICompilerDependencies

val <T> T.compose where T : IComposeDependencies, T : VersionsDependency
    get() = copy(artifactId = "$artifactId-compose")

val <T> T.ktx where T : IKtxDependencies, T : VersionsDependency
    get() = copy(artifactId = "$artifactId-ktx")

val <T> T.compiler where T : ICompilerDependencies, T : VersionsDependency
    get() = copy(artifactId = "$artifactId-compiler")
