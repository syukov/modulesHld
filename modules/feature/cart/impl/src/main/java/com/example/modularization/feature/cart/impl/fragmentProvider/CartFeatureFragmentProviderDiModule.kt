package com.example.modularization.feature.cart.impl.fragmentProvider

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface CartFeatureFragmentProviderDiModule {

    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: CartFeatureFragmentProviderImpl): CartFeatureFragmentProvider
}

