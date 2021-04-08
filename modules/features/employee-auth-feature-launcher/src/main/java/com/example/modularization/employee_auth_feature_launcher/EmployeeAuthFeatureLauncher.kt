package com.example.modularization.employee_auth_feature_launcher

import com.example.modularization.root_feature_data.RootRouter


interface EmployeeAuthFeatureLauncher {

    interface ComponentApi

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface ComponentInjector {
        fun inject(component: ComponentApi)
    }

    interface Dependencies {
        fun rootRouter(): RootRouter
    }
}
