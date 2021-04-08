package com.example.modularization.employee_auth_feature_launcher

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_data.RootRouter


interface EmployeeAuthFeatureLauncher {
    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
    }

    interface ComponentApi {
        fun getFragmentProvider(): FragmentProvider
    }

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface Dependencies {
        fun rootRouter(): RootRouter
    }
}
