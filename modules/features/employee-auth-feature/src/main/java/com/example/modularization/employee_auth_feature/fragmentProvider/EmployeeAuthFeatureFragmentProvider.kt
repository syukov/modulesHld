package com.example.modularization.employee_auth_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.root_feature_api.RootRouter

@DiDoc.Api
interface EmployeeAuthFeatureFragmentProvider {
    fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
}