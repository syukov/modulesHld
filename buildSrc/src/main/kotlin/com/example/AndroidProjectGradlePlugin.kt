package com.example

import com.android.build.gradle.BaseExtension
import com.example.settings.AndroidPluginSettings
import com.example.settings.DependenciesSettings
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.embeddedKotlinVersion
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class AndroidProjectGradlePlugin : AbstractProjectGradlePlugin() {
    override fun apply(target: Project) {
        applyPlugins(target)
        configurePlugins(target)
        applyDependencies(target)
    }

    override fun applyPlugins(project: Project) {
        super.applyPlugins(project)
        project.pluginManager.apply("kotlin-android")
        project.pluginManager.apply("kotlin-kapt")
        project.pluginManager.apply("kotlin-parcelize")
    }

    //    @SuppressWarnings("UnstableApiUsage")
    @Suppress("UnstableApiUsage")
    override fun configurePlugins(project: Project) {
        super.configurePlugins(project)
        // Конфигурация Android gradle plugin. Аналог блока android {} в groovy скрипте
        project.extensions.configure<BaseExtension> {
            compileSdkVersion(AndroidPluginSettings.compileSdkVersion)
            buildToolsVersion(AndroidPluginSettings.buildToolsVersion)
            defaultConfig {
                minSdkVersion(AndroidPluginSettings.minSdkVersion)
                targetSdkVersion(AndroidPluginSettings.targetSdkVersion)
                versionCode(AndroidPluginSettings.versionCode)
                versionName(AndroidPluginSettings.versionName)
                testInstrumentationRunner(AndroidPluginSettings.testInstrumentationRunner)
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

    override fun applyDependencies(project: Project) {
        super.applyDependencies(project)
        project.dependencies {
            // desugaring
            addCoreLibraryDesugaring(DependenciesSettings.Android.desugaring)

            // kotlin
            addImplementation(
                DependenciesSettings.Jetbrains.kotlinStdlibJdk7(embeddedKotlinVersion),
                DependenciesSettings.Jetbrains.kotlinReflect(embeddedKotlinVersion)
            )

            // androidx
            addImplementation(
                DependenciesSettings.Androidx.legacySupport,
                DependenciesSettings.Androidx.appcompat,
                DependenciesSettings.Androidx.recyclerview,
                DependenciesSettings.Androidx.cardview,
                DependenciesSettings.Androidx.constraintlayout,
                DependenciesSettings.Androidx.material,
                DependenciesSettings.Androidx.viewpager2,
                DependenciesSettings.Androidx.coreKtx
            )

            // unit tests
            addTestImplementation(
                DependenciesSettings.Junit.junit,
                DependenciesSettings.Mockk.mockk
            )

            // dagger
            addCompileOnly(DependenciesSettings.Glassfish.javaxAnnotation)
            addKapt(DependenciesSettings.Dagger.daggerCompiler)
            addImplementation(DependenciesSettings.Dagger.dagger)

            // cicerone
            addImplementation(DependenciesSettings.Terrakok.cicerone)
        }
    }
}