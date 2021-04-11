package com.example.modularization.cart_feature.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.app_api.AppComponentApiHolder
import com.example.modularization.cart_feature.screens.cart.CartFragment
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module
class CartFeatureModule {
    companion object {
        @PerFeatureScope
        @Provides
        fun providerFragmentProvider(
            cartFragment: Provider<CartFragment>,
        ): CartFeatureDi.FragmentProvider {
            return object : CartFeatureDi.FragmentProvider {
                override fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment {
                    return when (screen) {
                        MainRouter.Screen.CartFeature.Cart -> cartFragment.get()
                    }
                }
            }
        }

        @Provides
        fun provideAppContext(): Context = AppComponentApiHolder.componentApi.appContext()
    }
}