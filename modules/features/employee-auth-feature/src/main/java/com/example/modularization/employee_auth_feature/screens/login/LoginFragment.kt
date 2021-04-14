package com.example.modularization.employee_auth_feature.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.employee_auth_feature.databinding.FragmentLoginBinding
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import javax.inject.Inject

class LoginFragment @Inject constructor(
    private val rootRouter: RootRouter,
    private val securityDomainApi: SecurityDomainApi,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentLoginBinding.inflate(inflater).apply {
            debugToolsBtn.setOnClickListener {
                rootRouter.navigateTo(RootRouter.Screen.EmployeeAuthFeature.DebugTools)
            }
            mainBtn.setOnClickListener {
                runCase(
                    case = securityDomainApi.loginEmployee,
                    arg = "name",
                ) {
                    rootRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
                }
            }
        }.root
    }
}