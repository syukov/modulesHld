package com.example.modularization.feature.main.impl.fragmentProvider

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface MainFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: MainFeatureFragmentProviderImpl): MainFeatureFragmentProvider
}

