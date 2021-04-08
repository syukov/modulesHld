package com.example.modularization.main_feature_api

import com.example.modularization.root_feature_data.RootRouter


interface MainFeatureContract {

    interface Component

    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface ComponentInjector {
        fun inject(component: Component)
    }

    interface Dependencies {
        fun appRouter(): RootRouter
    }
}