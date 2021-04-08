package com.example.modularization.employee_auth_feature_impl.screens.deugTools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.employee_auth_feature_impl.databinding.FragmentDebugToolsBinding
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class DebugToolsFragment @Inject constructor(
    var rootRouter: RootRouter,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentDebugToolsBinding.inflate(inflater).apply {
            loginBtn.setOnClickListener {
                rootRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.Login)
            }
            mainBtn.setOnClickListener {
                rootRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }
}