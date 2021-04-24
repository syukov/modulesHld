package com.example.modularization.feature.employeeAuth.impl.screens.deugTools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.employeeAuth.impl.databinding.FragmentDebugToolsBinding
import com.example.modularization.root_feature_api.RootRouter
import javax.inject.Inject

class DebugToolsFragment @Inject constructor(
    private var rootRouter: RootRouter,
    private val securityDomainApi: SecurityDomainApi
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentDebugToolsBinding.inflate(inflater).apply {
            loginBtn.setOnClickListener {
                rootRouter.navigateBack()
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