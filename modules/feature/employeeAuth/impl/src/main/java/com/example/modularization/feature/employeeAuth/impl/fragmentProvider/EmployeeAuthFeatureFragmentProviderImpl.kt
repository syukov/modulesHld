package com.example.modularization.feature.employeeAuth.impl.fragmentProvider

import androidx.fragment.app.Fragment
import com.example.modularization.feature.employeeAuth.impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.feature.employeeAuth.impl.screens.login.LoginFragment
import com.example.modularization.feature.root.api.RootRouter
import javax.inject.Inject
import javax.inject.Provider


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