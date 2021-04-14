package com.example.modularization.root_feature.fragmentProvider

import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.core_feature.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@DiDoc.Api.DiModule
interface RootFeatureFragmentProviderDiModule {
    @Binds
    @PerFeatureScope
    fun bindFragmentProvider(impl: RootFeatureFragmentProviderImpl): RootFeatureFragmentProvider
}