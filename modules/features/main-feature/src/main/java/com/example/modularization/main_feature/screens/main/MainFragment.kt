package com.example.modularization.main_feature.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.main_feature.R
import com.example.modularization.main_feature.databinding.FragmentMainBinding
import com.example.modularization.main_feature.router.MainRouterFragmentFactory
import com.example.modularization.main_feature.router.TabSwitcherRouter
import com.example.modularization.main_feature.router.TabSwitcherRouterNavigator
import com.example.modularization.main_feature_api.MainRouter
import com.example.modularization.ui_core.mvp.BaseFragment
import com.example.modularization.ui_core.navigation.navigatorHolder
import javax.inject.Inject

class MainFragment @Inject constructor(
    private val tabSwitcherRouter: TabSwitcherRouter,
    private val mainRouter: MainRouter,
    private val tabSwitcherRouterNavigatorFactory: TabSwitcherRouterNavigator.Factory,
    private val fragmentFactory: MainRouterFragmentFactory,
) : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.fragmentFactory = fragmentFactory
        mainRouter.resetTabs(
            selectTab = MainRouter.Tab.Catalogue,
            MainRouter.Tab.Catalogue to MainRouter.Screen.CatalogueFeature.Catalogue,
            MainRouter.Tab.Cart to MainRouter.Screen.CartFeature.Cart
        )
    }

    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentMainBinding.inflate(inflater).also { binding = it }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.catalogueTabMenu -> {
                    mainRouter.changeTab(MainRouter.Tab.Catalogue)
                    true
                }
                R.id.cartTabMenu -> {
                    mainRouter.changeTab(MainRouter.Tab.Cart)
                    true
                }
                else -> false
            }
        }
    }

    override fun onResume() {
        super.onResume()
        tabSwitcherRouter.navigatorHolder.setNavigator(
            tabSwitcherRouterNavigatorFactory.create(childFragmentManager, R.id.mainContainer)
        )
    }

    override fun onPause() {
        super.onPause()
        tabSwitcherRouter.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed(): Boolean {
        mainRouter.navigateBack()
        return true
    }
}