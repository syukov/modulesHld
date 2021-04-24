package com.example.modularization.root_feature.fragmentProvider

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.feature.core.impl.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
@Doc.Api.DiModule
interface RootFeatureFragmentProviderDiModule {
    @Binds
    @PerFeatureScope
    fun bindFragmentProvider(impl: RootFeatureFragmentProviderImpl): RootFeatureFragmentProvider
}