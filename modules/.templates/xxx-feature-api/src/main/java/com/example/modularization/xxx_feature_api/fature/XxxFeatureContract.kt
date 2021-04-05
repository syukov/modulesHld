package com.example.modularization.xxx_feature_api.fature

import com.example.modularization.app_feature_api.data.AppRouter

interface XxxFeatureContract {

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
