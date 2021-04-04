package com.example.modularization.employee_auth_feature_impl.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.employee_auth_feature_api.fature.EmployeeAuthFeatureContract
import com.example.modularization.employee_auth_feature_impl.databinding.FragmentLoginBinding
import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.ui_core.mvp.BaseFragment
import kotlinx.android.synthetic.main.fragment_login.view.*
import javax.inject.Inject

class LoginFragment : BaseFragment(),
    AppRouter.ScreenFragment,
    EmployeeAuthFeatureContract.ComponentInjector {

    @Inject
    lateinit var appRouter: AppRouter

    override fun getScreen(): AppRouter.Screen = AppRouter.Screen.EmployeeAuthFeature.Login

    override fun inject(component: EmployeeAuthFeatureContract.Component) {
        (component as DaggerEmployeeAuthFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentLoginBinding.inflate(inflater).root.also {
            it.debugToolsBtn.setOnClickListener {
                appRouter.navigate(AppRouter.Command.Forward(AppRouter.Screen.EmployeeAuthFeature.DebugTools))
            }
        }
    }
}