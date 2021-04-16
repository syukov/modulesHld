package com.example.modularization.root_feature.di

import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.root_feature.fragmentProvider.RootFeatureFragmentProvider
import com.example.modularization.root_feature.fragmentProvider.RootFeatureFragmentProviderDiModule
import com.example.modularization.root_feature.router.RootRouterDiModule
import com.example.modularization.root_feature_api.RootRouter
import dagger.Component

@Doc.Structure
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
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        /* no-op */
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val rootRouter: RootRouter
        val fragmentProvider: RootFeatureFragmentProvider
    }
}