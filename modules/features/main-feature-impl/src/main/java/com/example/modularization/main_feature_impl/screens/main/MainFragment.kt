package com.example.modularization.main_feature_impl.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.main_feature_impl.databinding.FragmentMainBinding
import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment(),
    com.example.modularization.root_feature_data.RootRouter.ScreenFragment,
    MainFeatureContract.ComponentInjector {

    @Inject
    lateinit var appRouter: com.example.modularization.root_feature_data.RootRouter

    override fun getScreen(): com.example.modularization.root_feature_data.RootRouter.Screen =
        com.example.modularization.root_feature_data.RootRouter.Screen.MainFeature.Main

    override fun inject(component: MainFeatureContract.Component) {
        (component as DaggerMainFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).root.also {

        }
    }
}