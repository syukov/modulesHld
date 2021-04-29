package com.example.modularization.feature.root.impl.di

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.root.api.RootRouter
import com.example.modularization.feature.root.impl.fragmentProvider.RootFeatureFragmentProvider
import com.example.modularization.feature.root.impl.fragmentProvider.RootFeatureFragmentProviderDiModule
import com.example.modularization.feature.root.impl.router.RootRouterDiModule
import dagger.Component


interface RootFeatureDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            RootRouterDiModule::class,
            RootFeatureFragmentProviderDiModule::class,
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
        /* no-op */
    }


    interface ApplicationScopeDependencies {
        /* no-op */
    }


    interface DiComponentInterface {
        val rootRouter: RootRouter
        val fragmentProvider: RootFeatureFragmentProvider
    }
}