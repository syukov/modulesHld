package com.example.modularization.pdp_feature.fragmentProvider

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@DiDoc.Api.DiModule
interface PdpFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: PdpFeatureFragmentProviderImpl): PdpFeatureFragmentProvider
}