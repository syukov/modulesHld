/**
 * Каждая версия Gradle уже включает в себя определенную embedded версию котлина.
 * Если мы используем kotlin-dsl для написания плагинов, то эта embedded версия автоматически добавляется в classpath плагина.
 * Если же мы внутри кастомного плагина добавляем к градл модулю другие котлин плагины (что бы убрать повторение кода в каждом модуле),
 * то нам нужно следить за тем соответствием gradle embedded версии котлина и используемой в проекте версии котлина.
 *
 * Иными словами:
 * - в проекте используем версию котлина соответствующую Gradle embeddedKotlinVersion.
 * - для того что бы обновиться на новую версию котлина и всех его библиотек нужно так же обновить версию градла.
 *
 * Иначе получим варнинги при сборке и потенциальные краши в рантайме.
 */

buildscript {
    val androidGradlePluginVersion = "4.1.1"

    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
        classpath("com.android.tools.build:gradle:$androidGradlePluginVersion")
        classpath("com.android.tools.build:gradle:$androidGradlePluginVersion")
    }
}


plugins {
    id("java-gradle-plugin")
    `kotlin-dsl`
}


repositories {
    google()
    jcenter()
}

dependencies {
    val gradleVersion = "4.1.1"

    // доступ к kotlinOptions внутри плагина
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
    // доступ к блоку android{} внутри плагина
    implementation("com.android.tools.build:gradle:$gradleVersion")
}

gradlePlugin {
    plugins {
        register("android-application-gradle-plugin") {
            id = "android-application-gradle-plugin"
            implementationClass = "com.example.AndroidApplicationGradlePlugin"
        }
        register("android-library-gradle-plugin") {
            id = "android-library-gradle-plugin"
            implementationClass = "com.example.AndroidLibraryGradlePlugin"
        }
    }
}