package com.example.modularization.main_feature_impl.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.main_feature_api.fature.MainFeatureContract
import com.example.modularization.main_feature_impl.databinding.FragmentMainBinding
import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment(),
    AppRouter.ScreenFragment,
    MainFeatureContract.ComponentInjector {

    @Inject
    lateinit var appRouter: AppRouter

    override fun getScreen(): AppRouter.Screen = AppRouter.Screen.MainFeature.Main

    override fun inject(component: MainFeatureContract.Component) {
        (component as DaggerMainFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).root.also {

        }
    }
}