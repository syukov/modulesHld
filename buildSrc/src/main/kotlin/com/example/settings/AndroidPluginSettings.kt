package com.example.settings

object AndroidPluginSettings {
    var year = 21
    var major = 3
    var minor = 0
    var minSdkVersion = 23
    var targetSdkVersion = 29
    var compileSdkVersion = 29
    var buildToolsVersion = "29.0.2"
    var versionName = "\$year.\$major.\$minor"
    var versionCode = year * 10000 + major * 100 + minor
    var testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
}