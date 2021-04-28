@file:Suppress("UnstableApiUsage")

/**
 * Используем ту же версию котлина что встроена в используемый градл.
 * Студия не всегда корректно обрабатывает ссылку на [embeddedKotlinVersion].
 * Иногда показывает 1.3.72, хотя по факту в gradle 6.8 используется 1.4.20.
 */
pluginManagement {
    val androidGradlePluginVersion = "4.1.1"

    plugins {
        id("com.android.application") version androidGradlePluginVersion
        id("com.android.library") version androidGradlePluginVersion
        id("kotlin-android") version embeddedKotlinVersion
        id("kotlin-parcelize") version embeddedKotlinVersion apply (false)
        id("kotlin-kapt") version embeddedKotlinVersion
    }
}

/**
 * Добавляем в проект указанный модуль и его api и impl модули сабмодули, при их наличии.
 */
fun includeModules(projectPaths: String) {
    include(projectPaths)
    val dir = projectPaths.replace(":", "/").substring(1)
    file(dir).list { file, _ -> file.isDirectory }
        ?.forEach { subDir ->
            if (subDir == "api" || subDir == "impl") include("$projectPaths:$subDir")
        }
}

include(":modules")
includeModules(":modules:app")

include(":modules:domain")
includeModules(":modules:domain:core")
includeModules(":modules:domain:network")
includeModules(":modules:domain:security")
includeModules(":modules:domain:cart")


include(":modules:feature")
includeModules(":modules:feature:core")
includeModules(":modules:feature:root")
includeModules(":modules:feature:employeeAuth")
includeModules(":modules:feature:main")
includeModules(":modules:feature:cart")
includeModules(":modules:feature:catalogue")
includeModules(":modules:feature:pdp")
