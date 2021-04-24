package com.example.modularization.feature.cart.impl.fragmentProvider

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface CartFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: CartFeatureFragmentProviderImpl): CartFeatureFragmentProvider
}

