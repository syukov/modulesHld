package com.example.modularization.pdp_feature.di

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.fragmentProvider.PdpFeatureFragmentProvider
import com.example.modularization.pdp_feature.fragmentProvider.PdpFeatureFragmentProviderDiModule
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@DiDoc.Structure
interface PdpFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            PdpFeatureFragmentProviderDiModule::class,
            ApplicationScopeDependenciesDiModule::class,
        ]
    )
    @PerFeatureScope
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun getFragmentProvider(): PdpFeatureFragmentProvider

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        /* no-op */
    }
}