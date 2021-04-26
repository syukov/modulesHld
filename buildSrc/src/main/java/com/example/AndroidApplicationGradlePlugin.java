//package com.example;
//
//import com.android.build.gradle.AppExtension;
//import com.android.build.gradle.internal.dsl.BuildType;
//
//import org.gradle.api.Project;
//
//public class AndroidApplicationGradlePlugin extends AndroidProjectGradlePlugin {
//    @Override
//    void applyPlugins(Project project) {
//        project.getPluginManager().apply("com.android.application");
//        super.applyPlugins(project);
//
//        System.out.println(project.getProperties());
//    }
//
//    @Override
//    void configurePlugins(Project project) {
//        super.configurePlugins(project);
//        AppExtension androidExtension = project.getExtensions().getByType(AppExtension.class);
//        androidExtension.buildTypes(buildTypes -> {
//            BuildType release = buildTypes.findByName("release");
//            release.setMinifyEnabled(false);
//            release.proguardFiles(
//                    androidExtension.getDefaultProguardFile("proguard-android-optimize.txt"),
//                    "proguard-rules.pro"
//            );
//        });
//    }
//
//    @Override
//    void applyDependencies(Project project) {
//        super.applyDependencies(project);
//    }
//}