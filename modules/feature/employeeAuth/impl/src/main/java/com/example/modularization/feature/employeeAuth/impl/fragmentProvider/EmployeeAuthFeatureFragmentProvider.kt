package com.example.modularization.feature.employeeAuth.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.root.api.RootRouter


interface EmployeeAuthFeatureFragmentProvider {
    fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
}