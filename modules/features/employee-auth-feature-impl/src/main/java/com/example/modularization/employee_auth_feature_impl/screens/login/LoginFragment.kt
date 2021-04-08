package com.example.modularization.employee_auth_feature_impl.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.employee_auth_feature_impl.databinding.FragmentLoginBinding
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class LoginFragment @Inject constructor(
    private val rootRouter: RootRouter
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentLoginBinding.inflate(inflater).apply {
            debugToolsBtn.setOnClickListener {
                rootRouter.navigateTo(RootRouter.Screen.EmployeeAuthFeature.DebugTools)
            }
            mainBtn.setOnClickListener {
                rootRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }
}