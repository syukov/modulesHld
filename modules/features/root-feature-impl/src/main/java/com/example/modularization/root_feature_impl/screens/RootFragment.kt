package com.example.modularization.root_feature_impl.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.root_feature_impl.R
import com.example.modularization.root_feature_impl.databinding.FragmentRootBinding
import com.example.modularization.root_feature_impl.router.RootRouterFragmentFactory
import com.example.modularization.root_feature_impl.router.RootRouterNavigator
import com.example.modularization.ui_core.mvp.BaseFragment
import com.github.terrakok.cicerone.NavigatorHolder
import javax.inject.Inject

class RootFragment @Inject constructor(
    private var rootRouter: RootRouter,
    private var navigatorHolder: NavigatorHolder,
    private var navigatorFactory: RootRouterNavigator.Factory,
    private var fragmentFactory: RootRouterFragmentFactory,
) : BaseFragment() {

    private lateinit var navigator: RootRouterNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.fragmentFactory = fragmentFactory
        rootRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.DebugTools)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentRootBinding.inflate(inflater).root.also {
            navigator = navigatorFactory.create(this, R.id.rootContainer)
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