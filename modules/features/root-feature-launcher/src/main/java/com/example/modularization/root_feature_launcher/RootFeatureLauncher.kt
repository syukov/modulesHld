package com.example.modularization.root_feature_launcher

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter

interface RootFeatureLauncher {

    interface ComponentApi {
        fun getFragmentProvider(): FragmentProvider
    }


    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface Dependencies {
        fun rootRouterScreenToNameMapper(): RootRouter.ScreenToNameMapper
        fun appContext(): Context
        fun employeeAuthFeatureComponentFactoryApi(): EmployeeAuthFeatureLauncher.ComponentFactoryApi
        fun mainFeatureComponentFactoryApi(): MainFeatureLauncher.ComponentFactoryApi
    }

    interface FragmentProvider {
        fun getRootFragment(): Fragment
    }
}
