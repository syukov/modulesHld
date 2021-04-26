package com.example

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.withType
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

        // Конфигурация Android gradle plugin. Аналог блока android {} в groovy скрипте
        project.extensions.configure<BaseExtension> {
            compileSdkVersion(Const.AndroidProject.compileSdkVersion)
            buildToolsVersion(Const.AndroidProject.buildToolsVersion)
            defaultConfig {
                minSdkVersion(Const.AndroidProject.minSdkVersion)
                targetSdkVersion(Const.AndroidProject.targetSdkVersion)
                versionCode(Const.AndroidProject.versionCode)
                versionName(Const.AndroidProject.versionName)
                testInstrumentationRunner(Const.AndroidProject.testInstrumentationRunner)
                vectorDrawables.useSupportLibrary = true
            }

            compileOptions {
                isCoreLibraryDesugaringEnabled = true
                setSourceCompatibility(JavaVersion.VERSION_1_8)
                setTargetCompatibility(JavaVersion.VERSION_1_8)
            }

            buildFeatures.viewBinding = true

            project.tasks.withType<KotlinCompile>().configureEach {
                kotlinOptions {
                    languageVersion = "1.4"
                    jvmTarget = "1.8"

//                allWarningsAsErrors = true

                    freeCompilerArgs = freeCompilerArgs + listOf(
                        // Т.к. модули имеют одинаковые названия ("api" и "impl"), то говорим компилятору генерировать
                        // для каждого модуля META-INF на основе группы+названия проекта,
                        // т.е. вместо "impl.kotlin_module" будет "modules.app.impl.kotlin_module".
                        // Поскольку мы делаем это в каждой таске модуля, то будем получать такой варнинг "Argument -module-name is passed multiple times. Only the last value will be used"
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