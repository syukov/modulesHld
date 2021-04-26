package com.example;

public class Const {
    public static class AndroidProject {
        public static int year = 21;
        public static int major = 3;
        public static int minor = 0;

        public static int minSdkVersion = 23;
        public static int targetSdkVersion = 29;
        public static int compileSdkVersion = 29;
        public static String buildToolsVersion = "29.0.2";
        public static String versionName = "$year.$major.$minor";
        public static int versionCode = (year * 10000) + (major * 100) + minor;

        public static String testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner";
    }
}
