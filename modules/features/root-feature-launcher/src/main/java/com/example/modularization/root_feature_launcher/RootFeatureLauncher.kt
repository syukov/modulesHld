package com.example.modularization.root_feature_launcher

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.catalogue_feature_launcher.CatalogueFeatureLauncher
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.MainRouter
import com.example.modularization.root_feature_data.RootRouter

interface RootFeatureLauncher {
    interface FragmentProvider {
        fun getRootFragment(): Fragment
    }

    interface ComponentApi {
        fun getFragmentProvider(): FragmentProvider
    }

    interface ComponentFactoryApi {
        fun create(dependencies: Dependencies): ComponentApi
    }

    interface Dependencies {
        fun appContext(): Context
        fun rootRouterScreenResolver(): RootRouter.ScreensResolver
        fun employeeAuthFeatureComponentFactoryApi(): EmployeeAuthFeatureLauncher.ComponentFactoryApi
        fun mainFeatureComponentFactoryApi(): MainFeatureLauncher.ComponentFactoryApi
        fun mainRouterScreenResolver(): MainRouter.ScreensResolver
        fun catalogueComponentFactoryApi(): CatalogueFeatureLauncher.ComponentFactoryApi
    }
}
