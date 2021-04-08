package com.example.modularization.employee_auth_feature_impl.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.employee_auth_feature_impl.databinding.FragmentLoginBinding
import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class LoginFragment : BaseFragment(),
    RootRouter.ScreenFragment,
    EmployeeAuthFeatureLauncher.ComponentInjector {

    @Inject
    lateinit var appRouter: RootRouter

    override fun getScreen(): RootRouter.Screen = RootRouter.Screen.EmployeeAuthFeature.Login

    override fun inject(component: EmployeeAuthFeatureLauncher.ComponentApi) {
        (component as DaggerEmployeeAuthFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentLoginBinding.inflate(inflater).apply {
            debugToolsBtn.setOnClickListener {
                appRouter.navigateTo(RootRouter.Screen.EmployeeAuthFeature.DebugTools)
            }
            mainBtn.setOnClickListener {
                appRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }
}