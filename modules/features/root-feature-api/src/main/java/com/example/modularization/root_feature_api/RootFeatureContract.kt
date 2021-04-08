package com.example.modularization.root_feature_api

import android.content.Context
import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature_api.EmployeeAuthFeatureContract
import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.root_feature_data.RootRouter

interface RootFeatureContract {

    interface Component {
        fun getFragmentProvider(): FragmentProvider
    }


    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface Dependencies {
        fun rootRouterScreenToNameMapper(): RootRouter.ScreenToNameMapper
        fun appContext(): Context
        fun employeeAuthFeatureComponentFactory(): EmployeeAuthFeatureContract.ComponentFactory
        fun mainFeatureComponentFactory(): MainFeatureContract.ComponentFactory
    }

    interface FragmentProvider {
        fun getFragment(): Fragment
    }
}
