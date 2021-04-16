package com.example.modularization.pdp_feature.fragmentProvider

import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface PdpFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: PdpFeatureFragmentProviderImpl): PdpFeatureFragmentProvider
}