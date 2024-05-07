package com.github.chengzis.bom

import com.github.chengzis.bom.pom.Build
import com.github.chengzis.bom.pom.DependencyManagement
import com.github.chengzis.bom.pom.PluginManagement
import com.github.chengzis.bom.pom.Project
import com.github.chengzis.bom.utils.export
import com.github.chengzis.bom.version.*

object Androidx : IExportArtifact {

    object Core : VersionsDependency(
        groupId = "androidx.core",
        artifactId = "core",
        versions = listOf(
            Version("1.13.1", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            Version("1.10.1", AndroidSdkVersion.TIRAMISU),
            Version("1.8.0", AndroidSdkVersion.S),
            Version("1.6.0", AndroidSdkVersion.P),
        )
    ), IKtxDependencies {

        val animation = subArtifact(
            subArtifactId = "animation",
            versions = listOf(
                Version("1.0.0", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            )
        )

        val role = subArtifact(
            subArtifactId = "role",
            versions = listOf(
                Version("1.0.0", AndroidSdkVersion.P),
            )
        )

        val splashscreen = subArtifact(
            subArtifactId = "splashscreen",
            versions = listOf(
                Version("1.2.0-alpha01", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
                Version("1.1.0-rc01", AndroidSdkVersion.S),
            )
        )


    }

    object Activity : VersionsDependency(
        groupId = "androidx.activity",
        artifactId = "activity",
        versions = listOf(
            Version("1.9.0", AndroidSdkVersion.TIRAMISU),
            Version("1.5.1", AndroidSdkVersion.S),
            Version("1.3.1", AndroidSdkVersion.R),
            Version("1.2.4", AndroidSdkVersion.P),
        )
    ), IKtxDependencies, IComposeDependencies

    object Appcompat : VersionsDependency(
        groupId = "androidx.appcompat",
        artifactId = "appcompat",
        versions = listOf(
            Version("1.6.1", AndroidSdkVersion.TIRAMISU),
            Version("1.5.1", AndroidSdkVersion.S_V2),
            Version("1.4.2", AndroidSdkVersion.S),
            Version("1.3.1", AndroidSdkVersion.P),
        )
    ) {

        val resources = subArtifact(subArtifactId = "resources")

    }


    object Fragment : VersionsDependency(
        groupId = "androidx.fragment",
        artifactId = "fragment",
        versions = listOf(
            Version("1.6.2", AndroidSdkVersion.TIRAMISU),
            Version("1.5.7", AndroidSdkVersion.S),
            Version("1.4.1", AndroidSdkVersion.P),
        )
    ), IKtxDependencies


    object Hilt : VersionsDependency(
        groupId = "com.google.dagger",
        artifactId = "hilt-android",
        versions = listOf(
            Version("2.51", AndroidSdkVersion.S),
            Version("2.42", AndroidSdkVersion.R),
            Version("2.39", AndroidSdkVersion.P),
        )
    ), ICompilerDependencies {

        val gradlePlugin = VersionsDependency(
            groupId = "com.google.dagger.hilt.android",
            artifactId = "com.google.dagger.hilt.android.gradle.plugin",
            versions = versions
        )


    }

    object Lifecycle {

        private const val GROUP_ID = "androidx.lifecycle"

        private val versions = listOf(
            Version("2.7.0", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            Version("2.6.2", AndroidSdkVersion.TIRAMISU),
            Version("2.5.1", AndroidSdkVersion.S),
            Version("2.3.1", AndroidSdkVersion.P),
        )

        object Runtime : VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "lifecycle-runtime",
            versions = versions
        ), IKtxDependencies, IComposeDependencies


        object ViewModel : VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "lifecycle-viewmodel",
            versions = versions
        ), IKtxDependencies, IComposeDependencies {

            val saveState = subArtifact(subArtifactId = "savedstate")

        }


        object LiveData : VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "lifecycle-livedata",
            versions = versions
        ), IKtxDependencies


        val service = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "lifecycle-service",
            versions = versions
        )

        val process = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "lifecycle-process",
            versions = versions
        )

    }


    object Navigation {

        private const val GROUP_ID = "androidx.navigation"

        private val versions = listOf(
            Version("2.7.7", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            Version("2.6.0", AndroidSdkVersion.TIRAMISU),
            Version("2.5.3", AndroidSdkVersion.S),
            Version("2.3.5", AndroidSdkVersion.P),
        )

        object Fragment : VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "navigation-fragment",
            versions = versions
        ), IKtxDependencies

        object Ui : VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "navigation-ui",
            versions = versions
        ), IKtxDependencies


        val compose = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "navigation-compose",
            versions = versions.filter { it.minSdk >= AndroidSdkVersion.S }
        )

        val gradlePlugin = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "navigation-safe-args-gradle-plugin",
            versions = versions
        )
    }

    object Paging {

        private const val GROUP_ID = "androidx.paging"

        private val versions = listOf(
            Version("3.2.1", AndroidSdkVersion.TIRAMISU),
            Version("3.1.1", AndroidSdkVersion.S),
            Version("3.0.1", AndroidSdkVersion.P),
        )


        val runtime = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "paging-runtime",
            versions = versions
        )

        val common = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "paging-common",
            versions = versions
        )


        val compose = VersionsDependency(
            groupId = GROUP_ID,
            artifactId = "paging-compose",
            versions = versions.filter { it.minSdk >= AndroidSdkVersion.TIRAMISU }
        )

    }


    object Media3 : VersionsDependencyGroup(
        groupId = "androidx.media3",
        artifactId = "media3",
        versions = listOf(
            Version("1.3.1", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            Version("1.1.0", AndroidSdkVersion.TIRAMISU),
        )
    ) {

        val ui = subArtifact("ui")

        val session = subArtifact("session")

        val extractor = subArtifact("extractor")

        val cast = subArtifact("cast")

        val transformer = subArtifact("transformer")

        val effect = subArtifact("effect")

        val muxer = subArtifact("muxer")

        val container = subArtifact("container")

        val database = subArtifact("database")

        val decoder = subArtifact("decoder")

        val common = subArtifact("common")

        object ExoPlayer : VersionsDependency(
            groupId = groupId,
            artifactId = "$artifactId-exoplayer",
            versions = versions
        ) {

            val dash = subArtifact("dash")

            val hls = subArtifact("hls")

            val smoothStreaming = subArtifact("smoothstreaming")

            val rtsp = subArtifact("rtsp")

            val midi = subArtifact("midi")

            val ima = subArtifact("ima")

            val workManager = subArtifact("workmanager")

        }

        object DataSource : VersionsDependency(
            groupId = groupId,
            artifactId = "$artifactId-datasource",
            versions = versions
        ) {


            val cronet = subArtifact("cronet")

            val okhttp = subArtifact("okhttp")

            val rtmp = subArtifact("rtmp")

        }


    }


    private val startup = VersionsDependency(
        groupId = "androidx.startup",
        artifactId = "startup-runtime",
        versions = listOf(
            Version("1.1.1", AndroidSdkVersion.S),
            Version("1.1.0", AndroidSdkVersion.R),
            Version("1.0.0", AndroidSdkVersion.P),
        )
    )

    object Room : VersionsDependencyGroup(
        groupId = "androidx.room",
        artifactId = "room",
        versions = listOf(
            Version("2.6.1", AndroidSdkVersion.UPSIDE_DOWN_CAKE),
            Version("2.5.2", AndroidSdkVersion.TIRAMISU),
        )
    ), ICompilerDependencies, IKtxDependencies, ITestingDependencies {

        val runtime = subArtifact("runtime")

        val paging = subArtifact("paging")

        val rxjava2 = subArtifact("rxjava2")

        val rxjava3 = subArtifact("rxjava3")

        val guava = subArtifact("guava")
    }

    object Concurrent : VersionsDependency(
        groupId = "androidx.concurrent",
        artifactId = "concurrent",
        versions = listOf(
            Version("1.1.0", AndroidSdkVersion.P),
        )
    ) {

        object Futures : VersionsDependency(
            groupId = groupId,
            artifactId = "$artifactId-futures",
            versions = versions
        ), IKtxDependencies

    }

    object Test {

        val junit = VersionsDependency(
            groupId = "junit",
            artifactId = "junit",
            versions = listOf(
                Version("4.13.2", AndroidSdkVersion.P),
            )
        )

        val ext = VersionsDependency(
            groupId = "androidx.test.ext",
            artifactId = "junit",
            versions = listOf(
                Version("1.1.5", AndroidSdkVersion.P),

                )
        )

        val espresso = VersionsDependency(
            groupId = "androidx.test.espresso",
            artifactId = "espresso-core",
            versions = listOf(
                Version("3.5.1", AndroidSdkVersion.P),
            )
        )

        val rules = VersionsDependency(
            groupId = "androidx.test",
            artifactId = "rules",
            versions = listOf(
                Version("1.5.0", AndroidSdkVersion.P),
            )
        )

    }

    private val material = VersionsDependency(
        groupId = "com.google.android.material",
        artifactId = "material",
        versions = listOf(
            Version("1.12.0", AndroidSdkVersion.TIRAMISU),
            Version("1.9.0", AndroidSdkVersion.S_V2),
        )
    )

    private val constraintLayout = VersionsDependency(
        groupId = "androidx.constraintlayout",
        artifactId = "constraintlayout",
        versions = listOf(
            Version("2.1.4", AndroidSdkVersion.P),
        )
    )

    private fun build(sdkVersion: AndroidSdkVersion): Project {
        return Project(
            artifactId = "androidx-bom-${sdkVersion.sdkInt}",
            version = MODULE_VERSION,
            description = "androidx的bom",
            dependencyManagement = DependencyManagement(
                listOfNotNull(
                    Core.build(sdkVersion),
                    Core.ktx.build(sdkVersion),
                    Core.animation.build(sdkVersion),
                    Core.role.build(sdkVersion),
                    Core.splashscreen.build(sdkVersion),

                    Activity.build(sdkVersion),
                    Activity.ktx.build(sdkVersion),

                    Appcompat.build(sdkVersion),
                    Appcompat.resources.build(sdkVersion),

                    Fragment.build(sdkVersion),
                    Fragment.ktx.build(sdkVersion),

                    Lifecycle.Runtime.build(sdkVersion),
                    Lifecycle.Runtime.ktx.build(sdkVersion),
                    Lifecycle.Runtime.compose.build(sdkVersion),

                    Lifecycle.ViewModel.ktx.build(sdkVersion),
                    Lifecycle.ViewModel.compose.build(sdkVersion),
                    Lifecycle.ViewModel.saveState.build(sdkVersion),

                    Lifecycle.LiveData.ktx.build(sdkVersion),

                    Lifecycle.service.build(sdkVersion),

                    Lifecycle.process.build(sdkVersion),

                    Navigation.Fragment.build(sdkVersion),
                    Navigation.Fragment.ktx.build(sdkVersion),

                    Navigation.Ui.build(sdkVersion),
                    Navigation.Ui.ktx.build(sdkVersion),

                    Navigation.compose.build(sdkVersion),

                    Paging.common.build(sdkVersion),
                    Paging.runtime.build(sdkVersion),
                    Paging.compose.build(sdkVersion),

                    Media3.ExoPlayer.build(sdkVersion),
                    Media3.ExoPlayer.dash.build(sdkVersion),
                    Media3.ExoPlayer.hls.build(sdkVersion),
                    Media3.ExoPlayer.smoothStreaming.build(sdkVersion),
                    Media3.ExoPlayer.rtsp.build(sdkVersion),
                    Media3.ExoPlayer.midi.build(sdkVersion),
                    Media3.ExoPlayer.ima.build(sdkVersion),
                    Media3.ExoPlayer.workManager.build(sdkVersion),

                    Media3.DataSource.build(sdkVersion),
                    Media3.DataSource.cronet.build(sdkVersion),
                    Media3.DataSource.okhttp.build(sdkVersion),
                    Media3.DataSource.rtmp.build(sdkVersion),

                    Media3.ui.build(sdkVersion),
                    Media3.session.build(sdkVersion),
                    Media3.extractor.build(sdkVersion),
                    Media3.cast.build(sdkVersion),
                    Media3.transformer.build(sdkVersion),
                    Media3.effect.build(sdkVersion),
                    Media3.muxer.build(sdkVersion),
                    Media3.container.build(sdkVersion),
                    Media3.database.build(sdkVersion),
                    Media3.decoder.build(sdkVersion),
                    Media3.common.build(sdkVersion),

                    Hilt.build(sdkVersion),
                    Hilt.compiler.build(sdkVersion),

                    startup.build(sdkVersion),

                    Concurrent.Futures.build(sdkVersion),
                    Concurrent.Futures.ktx.build(sdkVersion),

                    Test.junit.build(sdkVersion),
                    Test.ext.build(sdkVersion),
                    Test.espresso.build(sdkVersion),
                    Test.rules.build(sdkVersion),

                    material.build(sdkVersion),

                    Room.runtime.build(sdkVersion),
                    Room.ktx.build(sdkVersion),
                    Room.compiler.build(sdkVersion),
                    Room.testing.build(sdkVersion),
                    Room.rxjava2.build(sdkVersion),
                    Room.rxjava3.build(sdkVersion),
                    Room.guava.build(sdkVersion),
                    Room.paging.build(sdkVersion),

                    constraintLayout.build(sdkVersion),
                )
            ),
            build = Build(
                pluginManagement = PluginManagement(
                    plugins = listOfNotNull(
                        Hilt.gradlePlugin.build(sdkVersion),
                        Navigation.gradlePlugin.build(sdkVersion),
                    )
                )
            )
        )
    }

    private const val MODULE_VERSION = "0.0.3-beta"

    override fun export() {
        build(AndroidSdkVersion.UPSIDE_DOWN_CAKE).export()
    }
}

fun main() {

    Androidx.export()
}
