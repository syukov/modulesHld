package com.example.modularization.feature.cart.impl.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.feature.cart.impl.fragmentProvider.CartFeatureFragmentProvider
import com.example.modularization.feature.cart.impl.fragmentProvider.CartFeatureFragmentProviderDiModule
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.root.api.RootRouter
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