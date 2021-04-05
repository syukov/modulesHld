package com.example.modularization.main_feature_api.fature

import com.example.modularization.app_feature_api.data.AppRouter

interface MainFeatureContract {

    interface Component

    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface ComponentInjector {
        fun inject(component: Component)
    }

    interface Dependencies {
        fun appRouter(): AppRouter
    }
}