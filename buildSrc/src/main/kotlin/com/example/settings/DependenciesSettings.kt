package com.example.settings

object DependenciesSettings {
    object Android {
        const val desugaring = "com.android.tools:desugar_jdk_libs:1.0.9"
    }

    object Jetbrains {
        fun kotlinStdlibJdk7(ver: String) = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$ver"
        fun kotlinReflect(ver: String) = "org.jetbrains.kotlin:kotlin-reflect:$ver"
    }

    object Androidx {
        const val legacySupport = "androidx.legacy:legacy-support-v13:1.0.0"
        const val recyclerview = "androidx.recyclerview:recyclerview:1.1.0"
        const val cardview = "androidx.cardview:cardview:1.0.0"
        const val coreKtx = "androidx.core:core-ktx:1.3.2"
        const val material = "com.google.android.material:material:1.2.1"
        const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.0.2"
        const val appcompat = "androidx.appcompat:appcompat:1.2.0"
        const val viewpager2 = "androidx.viewpager2:viewpager2:1.0.0"
        const val testRunner = "androidx.test:runner:1.3.0"
        const val testRules = "androidx.test:rules:1.3.0"
        const val roomRuntime = "androidx.room:room-runtime:2.2.5"
        const val roomCompiler = "androidx.room:room-compiler:2.2.5"
    }

    object Junit {
        const val junit = "junit:junit:4.13.1"
    }

    object Mockk {
        const val mockk = "io.mockk:mockk:1.10.2"
    }

    object Dagger {
        const val dagger = "com.google.dagger:dagger:2.29.1"
        const val daggerCompiler = "com.google.dagger:dagger-compiler:2.29.1"
    }

    object Glassfish {
        const val javaxAnnotation = "org.glassfish:javax.annotation:10.0-b28"
    }

    object Terrakok {
        const val cicerone = "com.github.terrakok:cicerone:7.0"
    }

    object Jakewharton {
        const val timber = "com.jakewharton.timber:timber:4.7.1"
    }

//        object detekt = [
//        detektCli: "io.gitlab.arturbosch.detekt:detekt-cli:$detektVer",
//        detektApi: "io.gitlab.arturbosch.detekt:detekt-api:$detektVer"
//        ]
}