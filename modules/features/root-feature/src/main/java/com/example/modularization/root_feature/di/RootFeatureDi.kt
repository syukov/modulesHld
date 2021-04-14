package com.example.modularization.root_feature.di

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.root_feature.fragmentProvider.RootFeatureFragmentProvider
import com.example.modularization.root_feature.fragmentProvider.RootFeatureFragmentProviderDiModule
import com.example.modularization.root_feature.router.RootRouterDiModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@DiDoc.Structure
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
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        /* no-op */
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val rootRouter: RootRouter
        val fragmentProvider: RootFeatureFragmentProvider
    }
}