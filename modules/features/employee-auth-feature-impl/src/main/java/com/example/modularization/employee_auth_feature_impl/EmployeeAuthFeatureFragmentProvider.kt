package com.example.modularization.employee_auth_feature_impl

import androidx.fragment.app.Fragment
import com.example.modularization.employee_auth_feature_impl.screens.deugTools.DebugToolsFragment
import com.example.modularization.employee_auth_feature_impl.screens.login.LoginFragment
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject
import javax.inject.Provider

/**
 * Реализация кинтерфейса с помощью которого родительская фича получает фрагмент из текущей фичи, для отображения в своем контейнере.
 */
class EmployeeAuthFeatureFragmentProvider @Inject constructor(
    private val loginFragment: Provider<LoginFragment>,
    private val debugToolsFragment: Provider<DebugToolsFragment>,
) : EmployeeAuthFeatureLauncher.FragmentProvider {
    override fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment {
        return when (screen) {
            RootRouter.Screen.EmployeeAuthFeature.Login -> loginFragment.get()
            RootRouter.Screen.EmployeeAuthFeature.DebugTools -> debugToolsFragment.get()
        }
    }
}