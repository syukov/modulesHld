package com.example.modularization.employee_auth_feature_impl.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class XxxFragment : BaseFragment(),
    AppRouter.ScreenFragment,
    XxxFeatureContract.ComponentInjector {

    @Inject
    lateinit var appRouter: AppRouter

    override fun getScreen(): AppRouter.Screen = AppRouter.Screen. // fill

    override

    fun inject(component: XxxFeatureContract.Component) {
        (component as DaggerXxxFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return FragmentLoginBinding.inflate(inflater).root.also {
//            it.debugToolsBtn.setOnClickListener {
//                appRouter.navigateTo(AppRouter.Screen.EmployeeAuthFeature.DebugTools)
//            }
//        }
    }
}