package com.example.modularization.feature.root.impl.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.root.api.RootRouter
import com.example.modularization.feature.root.impl.fragmentProvider.RootFeatureFragmentProvider
import com.example.modularization.feature.root.impl.fragmentProvider.RootFeatureFragmentProviderDiModule
import com.example.modularization.feature.root.impl.router.RootRouterDiModule
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