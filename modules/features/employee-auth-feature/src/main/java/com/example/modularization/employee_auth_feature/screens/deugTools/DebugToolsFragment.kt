package com.example.modularization.employee_auth_feature.screens.deugTools

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.employee_auth_feature.databinding.FragmentDebugToolsBinding
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class DebugToolsFragment @Inject constructor(
    var rootRouter: RootRouter,
) : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentDebugToolsBinding.inflate(inflater).apply {
            loginBtn.setOnClickListener {
                rootRouter.navigateBack()
            }
            mainBtn.setOnClickListener {
                rootRouter.navigateTo(RootRouter.Screen.MainFeature.Main)
            }
        }.root
    }
}