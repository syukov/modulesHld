package com.example.modularization.main_feature.di

import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.main_feature.fragmentProvider.MainFeatureFragmentProvider
import com.example.modularization.main_feature.fragmentProvider.MainFeatureFragmentProviderDiModule
import com.example.modularization.main_feature.router.MainRouterDiModule
import com.example.modularization.root_feature_api.RootRouter
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


