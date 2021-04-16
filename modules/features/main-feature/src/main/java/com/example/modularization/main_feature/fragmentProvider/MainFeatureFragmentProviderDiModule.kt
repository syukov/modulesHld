package com.example.modularization.main_feature.fragmentProvider

import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.core_feature.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface MainFeatureFragmentProviderDiModule {
    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: MainFeatureFragmentProviderImpl): MainFeatureFragmentProvider
}

