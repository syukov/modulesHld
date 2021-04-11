package com.example.modularization.main_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature.di.nestedFeatureProviders.CatalogueFeatureProviderModule
import com.example.modularization.main_feature.di.nestedFeatureProviders.PdpFeatureProviderModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

interface MainFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            MainFeatureModule::class,
            MainRouterModule::class,
            // TODO: добавляем сюда модули умеющие создавать компоненты вложенных фич
            CatalogueFeatureProviderModule::class,
            PdpFeatureProviderModule::class,
        ]
    )
    @PerFeatureScope
    interface FeatureComponent : GlobalDependencies {

        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): FeatureComponent
        }

        fun getFragmentProvider(): FragmentProvider
    }

    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment
    }

    interface FactoryDependencies {
        fun rootRouter(): RootRouter
    }

    interface GlobalDependencies {
        /* no-op */
    }
}


