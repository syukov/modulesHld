package com.example.modularization.main_feature.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.main_feature.R
import com.example.modularization.main_feature.databinding.FragmentMainBinding
import com.example.modularization.main_feature.router.MainRouterFragmentFactory
import com.example.modularization.main_feature.router.MainRouterNavigator
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val mainRouter: MainRouter,
    private val navigatorHolder: NavigatorHolder,
    private val navigatorFactory: MainRouterNavigator.Factory,
    private val fragmentFactory: MainRouterFragmentFactory,
) : BaseFragment() {

    private lateinit var navigator: MainRouterNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.fragmentFactory = fragmentFactory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).root.also {
            navigator = navigatorFactory.create(this, R.id.mainContainer)
            mainRouter.navigateTo(MainRouter.Screen.CatalogueFeature.Catalogue)
        }
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}