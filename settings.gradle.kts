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


fun includeAllModules(dir: String) {
    val modulePath = dir.replace("/", ":")
    include(modulePath)
    println("included $modulePath")

    val listFiles = file(dir).listFiles().orEmpty()

    val needToLookForSubModules = listFiles.none { file -> file.isDirectory && file.name == "src" }

    if (needToLookForSubModules) {
        listFiles
            .filter { file -> file.isDirectory }
            .forEach { file -> includeAllModules("$dir/${file.name}") }
    }
}

/**
 * Пробегаемся рекурсивно по подкаталогам "/modules" и добавляем в проект все дерево модулей.
 * Поиск вгубь прерывается на каталогах содержащих "/src".
 */
includeAllModules("/modules")