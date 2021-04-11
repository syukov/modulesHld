package com.example.modularization.root_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature.screens.RootFragment
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
interface RootFeatureModule {
    companion object {
        @Provides
        @PerFeatureScope
        fun provideFragmentProvider(
            rootFragmentProvider: Provider<RootFragment>,
        ): RootFeatureDi.FragmentProvider {
            return object : RootFeatureDi.FragmentProvider {
                override fun getRootFragment(): Fragment = rootFragmentProvider.get()
            }
        }
    }
}