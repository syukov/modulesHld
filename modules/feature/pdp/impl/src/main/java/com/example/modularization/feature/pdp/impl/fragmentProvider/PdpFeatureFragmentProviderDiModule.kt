package com.example.modularization.feature.pdp.impl.fragmentProvider

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface PdpFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: PdpFeatureFragmentProviderImpl): PdpFeatureFragmentProvider
}