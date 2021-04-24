package com.example.modularization.feature.employeeAuth.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.root_feature_api.RootRouter

@Doc.Api
interface EmployeeAuthFeatureFragmentProvider {
    fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
}