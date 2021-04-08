package com.example.modularization.main_feature_impl.di

import com.example.modularization.main_feature_impl.screens.main.MainFragment
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import dagger.Component

@Component(
    dependencies = [MainFeatureLauncher.Dependencies::class]
)
interface MainFeatureComponent : MainFeatureLauncher.ComponentApi {

    fun inject(fragment: MainFragment)

    @Component.Factory
    interface ComponentFactory : MainFeatureLauncher.ComponentFactoryApi {
        override fun create(dependencies: MainFeatureLauncher.Dependencies): MainFeatureComponent
    }
}