package com.example.modularization.feature.pdp.impl.di

import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.pdp.impl.fragmentProvider.PdpFeatureFragmentProvider
import com.example.modularization.feature.pdp.impl.fragmentProvider.PdpFeatureFragmentProviderDiModule
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component


interface PdpFeatureDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            PdpFeatureFragmentProviderDiModule::class,
            ApplicationScopeDependenciesDiModule::class,
        ]
    )
    @PerFeatureScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun getFragmentProvider(): PdpFeatureFragmentProvider

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): DiComponent
        }
    }


    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }


    interface ApplicationScopeDependencies {
        val appDomainApi: AppDomainApi
    }


    interface DiComponentInterface {
        /* no-op */
    }
}