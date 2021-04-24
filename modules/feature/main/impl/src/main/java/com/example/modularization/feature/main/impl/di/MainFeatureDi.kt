package com.example.modularization.feature.main.impl.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.impl.fragmentProvider.MainFeatureFragmentProvider
import com.example.modularization.feature.main.impl.fragmentProvider.MainFeatureFragmentProviderDiModule
import com.example.modularization.feature.main.impl.router.MainRouterDiModule
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component

@Doc.Structure
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
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }

    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: MainFeatureFragmentProvider
    }
}


