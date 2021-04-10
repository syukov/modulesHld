package com.example.modularization.root_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature.screens.RootFragment
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class RootFeatureModule {
    @Provides
    @PerFeatureScope
    fun provideFragmentProvider(
        rootFragmentProvider: Provider<RootFragment>,
    ): RootFeatureComponent.FragmentProvider {
        return object : RootFeatureComponent.FragmentProvider {
            override fun getRootFragment(): Fragment = rootFragmentProvider.get()
        }
    }
}