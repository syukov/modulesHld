package com.example.modularization.cart_feature.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.cart_feature.fragmentProvider.CartFeatureFragmentProvider
import com.example.modularization.cart_feature.fragmentProvider.CartFeatureFragmentProviderDiModule
import com.example.modularization.core_feature.di.PerFeatureScope
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import dagger.Component

@Doc.Structure
interface CartFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            ApplicationScopeDependenciesDiModule::class,
            CartFeatureFragmentProviderDiModule::class
        ]
    )
    @PerFeatureScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {

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
        val cartDomainApi: CartDomainApi
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val fragmentProvider: CartFeatureFragmentProvider
    }
}