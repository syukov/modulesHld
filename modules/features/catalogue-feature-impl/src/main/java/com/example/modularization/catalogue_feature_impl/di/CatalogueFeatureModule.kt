package com.example.modularization.catalogue_feature_impl.di

import com.example.modularization.catalogue_feature_impl.CatalogueFeatureFragmentProvider
import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface CatalogueFeatureModule {

    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: CatalogueFeatureFragmentProvider): CatalogueFeatureLauncher.FragmentProvider
}