package com.example

import com.example.settings.ProjectModule
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.project

abstract class AbstractProjectGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugins(target)
        configurePlugins(target)
        applyDependencies(target)
    }

    open fun applyPlugins(project: Project) {
    }

    @Suppress("UnstableApiUsage")
    open fun configurePlugins(project: Project) {
    }

    open fun applyDependencies(project: Project) {
        addTransitiveDependenciesOnAnotherModules(project)
    }

    /**
     * Предоставляем транзитивные зависимости к api и core моделям этого [ProjectModule].
     * Т.е. если из другого модуля будут видны классы этотго [ProjectModule], то будут видны так же классы его core и api модулей.
     */
    private fun addTransitiveDependenciesOnAnotherModules(currentProject: Project) {
        val projectModule = ProjectModule::class.sealedSubclasses
            .mapNotNull { projectModule -> projectModule.objectInstance }
            .find { projectModule -> projectModule.path == currentProject.path }

        val dependenciesOnAnotherModules = projectModule?.transitiveDependencies.orEmpty()

        currentProject.dependencies {
            dependenciesOnAnotherModules.forEach { anotherProjectModule ->
                add("api", project(anotherProjectModule.path))
            }
        }
    }


    // helper extension functions:

    fun DependencyHandler.addAll(configurationName: String, vararg dependencyNotations: String) =
        dependencyNotations.forEach { this.add(configurationName, it) }

    fun DependencyHandler.addApi(vararg dependencyNotations: String) =
        addAll("api", *dependencyNotations)

    fun DependencyHandler.addImplementation(vararg dependencyNotations: String) =
        addAll("implementation", *dependencyNotations)

    fun DependencyHandler.addCompileOnly(vararg dependencyNotations: String) =
        addAll("compileOnly", *dependencyNotations)

    fun DependencyHandler.addKapt(vararg dependencyNotations: String) =
        addAll("kapt", *dependencyNotations)

    fun DependencyHandler.addCoreLibraryDesugaring(vararg dependencyNotations: String) =
        addAll("coreLibraryDesugaring", *dependencyNotations)

    fun DependencyHandler.addTestImplementation(vararg dependencyNotations: String) =
        addAll("testImplementation", *dependencyNotations)

    fun DependencyHandler.addAndroidTestImplementation(vararg dependencyNotations: String) =
        addAll("androidTestImplementation", *dependencyNotations)

}