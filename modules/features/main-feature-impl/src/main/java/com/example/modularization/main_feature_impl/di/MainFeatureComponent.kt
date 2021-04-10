package com.example.modularization.main_feature_impl.di

import com.example.modularization.main_feature_impl.di.nestedFeatureProviders.CatalogueFeatureProviderModule
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [MainFeatureLauncher.Dependencies::class],
    modules = [
        MainFeatureModule::class,
        MainRouterModule::class,
        // providers of nested features modules TODO: добавляем сюда модули умеющие создавать компоненты вложенных фич
        CatalogueFeatureProviderModule::class
    ]
)
@PerFeatureScope
interface MainFeatureComponent : MainFeatureLauncher.ComponentApi {

    @Component.Factory
    interface ComponentFactory : MainFeatureLauncher.ComponentFactoryApi {
        override fun create(dependencies: MainFeatureLauncher.Dependencies): MainFeatureComponent
    }
}