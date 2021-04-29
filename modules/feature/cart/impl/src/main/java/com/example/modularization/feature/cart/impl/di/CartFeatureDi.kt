package com.example.modularization.feature.cart.impl.di

import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.feature.cart.impl.fragmentProvider.CartFeatureFragmentProvider
import com.example.modularization.feature.cart.impl.fragmentProvider.CartFeatureFragmentProviderDiModule
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.root.api.RootRouter
import dagger.Component


interface CartFeatureDi {

    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CartFeatureFragmentProviderDiModule::class
        ]
    )
    @PerFeatureScope
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
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
        val cartDomainApi: CartDomainApi
    }


    interface DiComponentInterface {
        val fragmentProvider: CartFeatureFragmentProvider
    }
}