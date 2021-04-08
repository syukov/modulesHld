package com.example.modularization.employee_auth_feature_api

import com.example.modularization.root_feature_data.RootRouter


interface EmployeeAuthFeatureContract {

    interface Component

    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface ComponentInjector {
        fun inject(component: Component)
    }

    interface Dependencies {
        fun rootRouter(): RootRouter
    }
}
