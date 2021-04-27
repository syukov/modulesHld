package com.example.settings

import org.gradle.kotlin.dsl.DependencyHandlerScope

class DependencyHandlerScopeExt(private val scope: DependencyHandlerScope) {
    private fun addAll(configurationName: String, vararg deps: String) {
        deps.forEach { scope.add(configurationName, it) }
    }

    fun api(vararg deps: String) = addAll("api", *deps)
    fun implementation(vararg deps: String) = addAll("implementation", *deps)
    fun compileOnly(vararg deps: String) = addAll("compileOnly", *deps)
    fun kapt(vararg deps: String) = addAll("kapt", *deps)
    fun coreLibraryDesugaring(vararg deps: String) = addAll("coreLibraryDesugaring", *deps)
    fun testImplementation(vararg deps: String) = addAll("testImplementation", *deps)
    fun androidTestImplementation(vararg deps: String) = addAll("androidTestImplementation", *deps)
}