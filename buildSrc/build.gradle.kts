plugins {
    `kotlin-dsl`
}

buildscript {
    val gradleVersion = "4.1.1"

    repositories {
        google()
        jcenter()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
        classpath("com.android.tools.build:gradle:$gradleVersion")
    }
}


repositories {
    google()
    jcenter()
    mavenCentral()
    gradlePluginPortal()
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