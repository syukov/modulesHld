package com.example.modularization.pdp_feature.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.fragmentProvider.PdpFeatureFragmentProvider
import com.example.modularization.pdp_feature.fragmentProvider.PdpFeatureFragmentProviderDiModule
import com.example.modularization.root_feature_api.RootRouter
import dagger.Component

@Doc.Structure
interface PdpFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            PdpFeatureFragmentProviderDiModule::class,
            ApplicationScopeDependenciesDiModule::class,
        ]
    )
    @PerFeatureScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun getFragmentProvider(): PdpFeatureFragmentProvider

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        /* no-op */
    }
}