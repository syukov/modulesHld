@file:Suppress("UnstableApiUsage")

pluginManagement {
    val kotlinVer = "1.4.20"
    val androidGradlePluginVersion = "4.1.1"

    plugins {
        id("com.android.application") version androidGradlePluginVersion
        id("com.android.library") version androidGradlePluginVersion
        id("kotlin-android") version kotlinVer
        id("kotlin-parcelize") version kotlinVer apply (false)
        id("kotlin-kapt") version kotlinVer
    }
}

/**
 * Добавляем в проект указанный модуль и его api и impl модули сабмодули, при их наличии.
 */
fun includeModules(modulePath: String) {
    include(modulePath)
    val dir = modulePath.replace(":", "/").substring(1)
    file(dir).list { file, _ -> file.isDirectory }
        ?.forEach { subDir ->
            if (subDir == "api" || subDir == "impl") include(modulePath + ":" + subDir)
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
