package com.example.modularization.main_feature_launcher

import com.example.modularization.root_feature_data.RootRouter


interface MainFeatureLauncher {

    interface ComponentApi

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface ComponentInjector {
        fun inject(component: ComponentApi)
    }

    interface Dependencies {
        fun appRouter(): RootRouter
    }
}