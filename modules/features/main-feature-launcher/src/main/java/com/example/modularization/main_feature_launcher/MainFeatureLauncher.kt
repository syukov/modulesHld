package com.example.modularization.main_feature_launcher

import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter


interface MainFeatureLauncher {

    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.MainFeature): Fragment
    }

    interface ComponentApi {
        fun getFragmentProvider(): FragmentProvider
    }

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface Dependencies {
        fun rootRouter(): RootRouter
        fun mainRouterScreenResolver(): MainRouter.ScreensResolver
        fun catalogueComponentFactoryApi(): CatalogueFeatureLauncher.ComponentFactoryApi
    }
}