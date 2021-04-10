package com.example.modularization.main_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature.di.nestedFeatureProviders.CatalogueFeatureProviderModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [MainFeatureComponent.Dependencies::class],
    modules = [
        MainFeatureModule::class,
        MainRouterModule::class,
        // providers of nested features modules TODO: добавляем сюда модули умеющие создавать компоненты вложенных фич
        CatalogueFeatureProviderModule::class
    ]
)
@PerFeatureScope
interface MainFeatureComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(dependencies: Dependencies): MainFeatureComponent
    }

    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment
    }

    fun getFragmentProvider(): FragmentProvider

    interface Dependencies {
        fun rootRouter(): RootRouter
    }
}