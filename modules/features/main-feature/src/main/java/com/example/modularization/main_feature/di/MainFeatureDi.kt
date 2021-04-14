package com.example.modularization.main_feature.di

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.main_feature.fragmentProvider.MainFeatureFragmentProvider
import com.example.modularization.main_feature.fragmentProvider.MainFeatureFragmentProviderDiModule
import com.example.modularization.main_feature.router.MainRouterDiModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@DiDoc.Structure
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
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }

    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: MainFeatureFragmentProvider
    }
}


