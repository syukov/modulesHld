package com.example.modularization.main_feature_impl.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.main_feature_impl.databinding.FragmentMainBinding
import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import javax.inject.Inject

class MainFragment : BaseFragment(),
    RootRouter.ScreenFragment,
    MainFeatureLauncher.ComponentInjector {

    @Inject
    lateinit var appRouter: RootRouter

    override fun getScreen(): RootRouter.Screen = RootRouter.Screen.MainFeature.Main

    override fun inject(component: MainFeatureLauncher.ComponentApi) {
        (component as DaggerMainFeatureComponent).inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).root.also {
            //TODO: реализовать mainFragment
        }
    }
}