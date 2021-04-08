package com.example.modularization.root_feature_impl.di

import com.example.modularization.root_feature_impl.di.nestedFeatureProviders.EmployeeAuthFeatureProviderModule
import com.example.modularization.root_feature_impl.di.nestedFeatureProviders.MainFeatureProviderModule
import com.example.modularization.root_feature_impl.screens.RootFragment
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [RootFeatureLauncher.Dependencies::class],
    modules = [
        RootRouterModule::class,
        RootFeatureModule::class,
        EmployeeAuthFeatureProviderModule::class,
        MainFeatureProviderModule::class,
    ]
)
@PerFeatureScope
interface RootFeatureComponent : RootFeatureLauncher.ComponentApi {

    fun inject(fragment: RootFragment)

    @Component.Factory
    interface ComponentFactory : RootFeatureLauncher.ComponentFactoryApi {
        override fun create(dependencies: RootFeatureLauncher.Dependencies): RootFeatureComponent
    }
}