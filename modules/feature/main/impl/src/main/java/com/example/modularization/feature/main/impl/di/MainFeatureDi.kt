package com.example.modularization.feature.main.impl.di

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.impl.fragmentProvider.MainFeatureFragmentProvider
import com.example.modularization.feature.main.impl.fragmentProvider.MainFeatureFragmentProviderDiModule
import com.example.modularization.feature.main.impl.router.MainRouterDiModule
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component


interface MainFeatureDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            MainFeatureFragmentProviderDiModule::class,
            MainRouterDiModule::class,
            NestedScopeComponentsDiModule::class,
        ]
    )
    @PerFeatureScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }

    }


    interface FactoryDependencies {
        val rootRouter: RootRouter
    }


    interface ApplicationScopeDependencies {
        /* no-op */
    }


    interface DiComponentInterface {
        val fragmentProvider: MainFeatureFragmentProvider
    }
}


