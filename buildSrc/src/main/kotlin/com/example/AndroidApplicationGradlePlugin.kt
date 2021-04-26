package com.example

import com.android.build.gradle.AppExtension
import org.gradle.api.Project

class AndroidApplicationGradlePlugin : AndroidProjectGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.pluginManager.apply("com.android.application")
        super.applyPlugins(project)
    }

    override fun configurePlugins(project: Project) {
        super.configurePlugins(project)
        project.extensions.getByType(AppExtension::class.java).apply {
            defaultConfig.apply {
                applicationId = "com.example.modularization"
            }

            buildTypes.apply {
                findByName("release")?.apply {
                    isMinifyEnabled = false
                    proguardFiles(
                        getDefaultProguardFile("proguard-android-optimize.txt"),
                        "proguard-rules.pro"
                    )
                }
            }
        }
    }

    override fun applyDependencies(project: Project) {
        super.applyDependencies(project)
    }
}