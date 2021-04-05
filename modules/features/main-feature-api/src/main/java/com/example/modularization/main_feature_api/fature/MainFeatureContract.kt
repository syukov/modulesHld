package com.example.modularization.main_feature_api.fature

import com.example.modularization.app_feature_api.data.AppRouter

interface MainFeatureContract {

    interface Dependencies {
        fun appRouter(): AppRouter
    }

    interface Component

    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface ComponentInjector {
        fun inject(component: Component)
    }
}
