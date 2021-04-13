package com.example.modularization.cart_feature.di

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

interface CartFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [CartFeatureModule::class]
    )
    @PerFeatureScope
    interface FeatureComponent : GlobalDependencies {
        fun getFragmentProvider(): FragmentProvider

        @Component.Factory
        interface Factory {
            fun create(dependencies: FactoryDependencies): FeatureComponent
        }
    }

    interface FragmentProvider {
        fun getFragment(screen: MainRouter.Screen.CartFeature): Fragment
    }

    interface FactoryDependencies {
        val rootRouter: RootRouter
        val mainRouter: MainRouter
    }

    interface GlobalDependencies {
        val context: Context
    }
}