package com.example.modularization.main_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.main_feature.screens.main.MainFragment
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class MainFeatureModule {

    @PerFeatureScope
    @Provides
    fun provideFragmentProvider(
        mainFragment: Provider<MainFragment>,
    ): MainFeatureComponent.FragmentProvider {
        return object : MainFeatureComponent.FragmentProvider {
            override fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment {
                return when (screen) {
                    RootRouter.Screen.MainFeature.Main -> mainFragment.get()
                }
            }
        }
    }
}