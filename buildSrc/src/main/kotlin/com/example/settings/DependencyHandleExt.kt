package com.example.settings

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project

/**
 * Предоставляем транзитивные зависимости к api и core моделям этого [projectModule].
 * Т.е. если из другого модуля будут видны классы этотго [projectModule], то будут видны так же классы его core и api модулей.
 */
fun DependencyHandler.initThisModule(projectModule: ProjectModule) =
    modulesApi(*projectModule.transitiveDependencies.toTypedArray())

fun DependencyHandler.modulesApi(vararg projectModules: ProjectModule) =
    projectModules.forEach { projectModule -> add("api", project(projectModule.path)) }

fun DependencyHandler.modulesImplementation(vararg projectModules: ProjectModule) =
    projectModules.forEach { projectModule -> add("implementation", project(projectModule.path)) }
