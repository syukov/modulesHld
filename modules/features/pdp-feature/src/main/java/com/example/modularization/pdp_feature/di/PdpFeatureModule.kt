package com.example.modularization.pdp_feature.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.app_api.AppComponentApiHolder
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.pdp_feature.screens.pdp.PdpFragment
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class PdpFeatureModule {
    companion object {
        @PerFeatureScope
        @Provides
        fun providerFragmentProvider(
            pdpFragment: Provider<PdpFragment>,
        ): PdpFeatureDi.FragmentProvider {
            return object : PdpFeatureDi.FragmentProvider {
                override fun getFragment(screen: MainRouter.Screen.PdpFeature): Fragment {
                    return when (screen) {
                        MainRouter.Screen.PdpFeature.Pdp -> pdpFragment.get()
                    }
                }
            }
        }

        @Provides
        fun provideAppContext(): Context = AppComponentApiHolder.componentApi.appContext()
    }
}