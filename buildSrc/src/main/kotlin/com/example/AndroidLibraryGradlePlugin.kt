package com.example

import org.gradle.api.Project

class AndroidLibraryGradlePlugin : AndroidProjectGradlePlugin() {
    override fun applyPlugins(project: Project) {
        project.pluginManager.apply("com.android.library")
        super.applyPlugins(project)
    }

    override fun configurePlugins(project: Project) {
        super.configurePlugins(project)
    }

    override fun applyDependencies(project: Project) {
        super.applyDependencies(project)
    }
}