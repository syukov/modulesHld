package com.example.modularization.catalogue_feature_launcher

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter


interface CatalogueFeatureLauncher {
    interface FragmentProvider {
        fun getFragment(screen: MainRouter.Screen.CatalogueFeature): Fragment
    }

    interface ComponentApi {
        fun getFragmentProvider(): FragmentProvider
    }

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface Dependencies {
        fun rootRouter(): RootRouter
        fun mainRouter(): MainRouter
    }
}
