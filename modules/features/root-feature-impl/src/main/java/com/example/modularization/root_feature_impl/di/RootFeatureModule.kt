package com.example.modularization.root_feature_impl.di

import com.example.modularization.root_feature_impl.di.fragmentProvider.RootFeatureFragmentProvider
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import dagger.Binds
import dagger.Module

@Module
interface RootFeatureModule {

    /**
     * Отдает фрагмент родительской фиче.
     */
    @Binds
    fun bindFragmentProvider(impl: RootFeatureFragmentProvider): RootFeatureLauncher.FragmentProvider
}