package com.example.modularization.main_feature.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.core_feature.mvp.BaseFragment
import com.example.modularization.core_feature.navigation.navigatorHolder
import com.example.modularization.main_feature.R
import com.example.modularization.main_feature.databinding.FragmentMainBinding
import com.example.modularization.main_feature.router.MainRouterFragmentFactory
import com.example.modularization.main_feature.router.MainRouterImpl
import com.example.modularization.main_feature.router.tabSwitcher.TabSwitcherRouter
import com.example.modularization.main_feature.router.tabSwitcher.TabSwitcherRouterNavigator
import com.example.modularization.main_feature_api.MainRouter
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
        val tabChangeListener: (MainRouter.Tab) -> Unit = { tab ->
            binding.bottomNavigationView.selectedItemId = when (tab) {
                MainRouter.Tab.Catalogue -> R.id.catalogueTabMenu
                MainRouter.Tab.Cart -> R.id.cartTabMenu
            }
        }
        (mainRouter as MainRouterImpl).tabChangeListener = tabChangeListener
        tabChangeListener(mainRouter.activeTab)
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