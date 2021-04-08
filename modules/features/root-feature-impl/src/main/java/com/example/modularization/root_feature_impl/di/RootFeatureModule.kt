package com.example.modularization.root_feature_impl.di

import com.example.modularization.root_feature_api.RootFeatureContract
import com.example.modularization.root_feature_impl.fragmentProvider.RootFeatureFragmentProvider
import dagger.Binds
import dagger.Module

@Module
interface RootFeatureModule {

    @Binds
    fun bindFragmentProvider(impl: RootFeatureFragmentProvider): RootFeatureContract.FragmentProvider
}