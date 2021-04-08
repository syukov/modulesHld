package com.example.modularization.main_feature_impl.di

import com.example.modularization.main_feature_impl.MainFeatureFragmentProvider
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Binds
import dagger.Module

@Module
interface MainFeatureModule {

    @PerFeatureScope
    @Binds
    fun bindFragmentProvider(impl: MainFeatureFragmentProvider): MainFeatureLauncher.FragmentProvider
}