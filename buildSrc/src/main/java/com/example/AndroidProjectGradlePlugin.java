package com.example;

import com.android.build.gradle.AppExtension;

import org.gradle.api.JavaVersion;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile;

import java.util.ArrayList;

import kotlin.Unit;

public class AndroidProjectGradlePlugin implements Plugin<Project> {

    @Override
    public void apply(@NotNull Project target) {
        applyPlugins(target);
        configurePlugins(target);
        applyDependencies(target);
    }

    void applyPlugins(Project project) {
        project.getPluginManager().apply("kotlin-android");
        project.getPluginManager().apply("kotlin-kapt");
        project.getPluginManager().apply("kotlin-parcelize");
    }

    //    @SuppressWarnings("UnstableApiUsage")
    void configurePlugins(Project project) {
        AppExtension androidExtension = project.getExtensions().getByType(AppExtension.class);
        androidExtension.compileSdkVersion(Const.AndroidProject.compileSdkVersion);
        androidExtension.buildToolsVersion(Const.AndroidProject.buildToolsVersion);

        androidExtension.defaultConfig(defaultConfig -> {
            defaultConfig.minSdkVersion(Const.AndroidProject.minSdkVersion);
            defaultConfig.targetSdkVersion(Const.AndroidProject.targetSdkVersion);
            defaultConfig.versionCode(Const.AndroidProject.versionCode);
            defaultConfig.versionName(Const.AndroidProject.versionName);
            defaultConfig.testInstrumentationRunner(Const.AndroidProject.testInstrumentationRunner);
            defaultConfig.vectorDrawables(vectorDrawables -> {
                vectorDrawables.setUseSupportLibrary(true);
            });
        });

        androidExtension.compileOptions(compileOptions -> {
            compileOptions.setCoreLibraryDesugaringEnabled(true);
            compileOptions.setSourceCompatibility(JavaVersion.VERSION_1_8);
            compileOptions.setTargetCompatibility(JavaVersion.VERSION_1_8);
        });

        //noinspection UnstableApiUsage
        androidExtension.getBuildFeatures().setViewBinding(true);

        project.getTasks().withType(KotlinCompile.class, kotlinCompile -> {
            kotlinCompile.kotlinOptions(kotlinJvmOptions -> {
                kotlinJvmOptions.setLanguageVersion("1.4");
                kotlinJvmOptions.setJvmTarget(JavaVersion.VERSION_1_8.toString());

//                kotlinJvmOptions.setAllWarningsAsErrors(true);

                ArrayList<String> compilerArgs = new ArrayList<>(kotlinJvmOptions.getFreeCompilerArgs());
                // т.к. модули имеют одинаковые названия "api" и "impl", то говорим компилятору генерировать для
                // каждого модуля META-INF на основе группы+названия проекта, т.е. вместо "impl.kotlin_module" будет "modules.app.impl.kotlin_module"
                compilerArgs.add("-module-name");
                compilerArgs.add(project.getGroup() + "." + project.getName());
                // поддержка inline классов
                compilerArgs.add("-Xinline-classes");
                kotlinJvmOptions.setFreeCompilerArgs(compilerArgs);
                return Unit.INSTANCE;
            });
        });
    }

    void applyDependencies(Project project) {
    }
}