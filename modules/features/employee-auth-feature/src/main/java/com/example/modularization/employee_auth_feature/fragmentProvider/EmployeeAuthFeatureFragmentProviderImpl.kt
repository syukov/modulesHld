package com.example.modularization.employee_auth_feature.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.employee_auth_feature.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature.screens.login.LoginFragment
import com.example.modularization.root_feature_api.RootRouter
import javax.inject.Inject
import javax.inject.Provider

@Doc.Api.Implementation
class EmployeeAuthFeatureFragmentProviderImpl @Inject constructor(
    private val loginFragment: Provider<LoginFragment>,
    private val debugToolsFragment: Provider<DebugToolsFragment>,
) : EmployeeAuthFeatureFragmentProvider {
    override fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment {
        return when (screen) {
            RootRouter.Screen.EmployeeAuthFeature.Login -> loginFragment.get()
            RootRouter.Screen.EmployeeAuthFeature.DebugTools -> debugToolsFragment.get()
        }
    }
}