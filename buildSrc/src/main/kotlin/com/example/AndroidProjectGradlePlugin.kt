package com.example

import com.android.build.gradle.BaseExtension
import com.android.build.gradle.internal.dsl.VectorDrawablesOptions
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class AndroidProjectGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        applyPlugins(target)
        configurePlugins(target)
        applyDependencies(target)
    }

    open fun applyPlugins(project: Project) {
        project.pluginManager.apply("kotlin-android")
        project.pluginManager.apply("kotlin-kapt")
        project.pluginManager.apply("kotlin-parcelize")
    }

    //    @SuppressWarnings("UnstableApiUsage")
    @Suppress("UnstableApiUsage")
    open fun configurePlugins(project: Project) {
        // аналог блока android {} в градл скрипте
        project.extensions.getByType(BaseExtension::class.java).apply {
            compileSdkVersion(Const.AndroidProject.compileSdkVersion)
            buildToolsVersion(Const.AndroidProject.buildToolsVersion)
            defaultConfig.apply {
                minSdkVersion(Const.AndroidProject.minSdkVersion)
                targetSdkVersion(Const.AndroidProject.targetSdkVersion)
                versionCode(Const.AndroidProject.versionCode)
                versionName(Const.AndroidProject.versionName)
                testInstrumentationRunner(Const.AndroidProject.testInstrumentationRunner)
                vectorDrawables.also { vectorDrawables: VectorDrawablesOptions ->
                    vectorDrawables.useSupportLibrary = true
                }
            }
            compileOptions.apply {
                isCoreLibraryDesugaringEnabled = true
                setSourceCompatibility(JavaVersion.VERSION_1_8)
                setTargetCompatibility(JavaVersion.VERSION_1_8)
            }
            buildFeatures.viewBinding = true

            project.tasks.withType(KotlinCompile::class.java).forEach { kotlinCompile ->
                kotlinCompile.kotlinOptions {
                    languageVersion = "1.4"
                    jvmTarget = JavaVersion.VERSION_1_8.toString()

//                allWarningsAsErrors = true

                    freeCompilerArgs = freeCompilerArgs + listOf(
                        // т.к. модули имеют одинаковые названия "api" и "impl", то говорим компилятору генерировать для
                        // каждого модуля META-INF на основе группы+названия проекта, т.е. вместо "impl.kotlin_module" будет "modules.app.impl.kotlin_module"
                        "-module-name", "${project.group}.${project.name}",

                        // поддержка inline классов
                        "-Xinline-classes"
                    )
                }
            }
        }
    }

    open fun applyDependencies(project: Project) {}
}