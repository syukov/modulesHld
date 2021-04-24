package com.example.modularization.main_feature.screens.tabs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.core.impl.navigation.RouterNavigator
import com.example.modularization.main_feature.R
import com.example.modularization.main_feature.databinding.FragmentTabContainerBinding
import com.example.modularization.main_feature.router.MainRouterFragmentCreator
import com.example.modularization.main_feature.router.MainRouterFragmentFactory
import com.example.modularization.main_feature_api.MainRouter
import com.github.terrakok.cicerone.NavigatorHolder

class TabContainerFragment(
    val tab: MainRouter.Tab,
    private val mainRouterFragmentCreator: MainRouterFragmentCreator,
    private val fragmentFactory: MainRouterFragmentFactory,
    private val navigatorHolder: NavigatorHolder
) : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.fragmentFactory = fragmentFactory
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentTabContainerBinding.inflate(inflater).root
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(
            RouterNavigator(
                routerFragmentCreator = mainRouterFragmentCreator,
                fragmentManager = childFragmentManager,
                containerId = R.id.tabContainer
            )
        )
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}