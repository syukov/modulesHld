package com.example.modularization.feature.catalogue.impl.fragmentProvider

import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface CatalogueFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: CatalogueFeatureFragmentProviderImpl): CatalogueFeatureFragmentProvider
}