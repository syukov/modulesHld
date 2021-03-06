package com.example.modularization.feature.main.impl.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.core.impl.navigation.navigatorHolder
import com.example.modularization.feature.main.api.MainRouter
import com.example.modularization.feature.main.impl.R
import com.example.modularization.feature.main.impl.databinding.FragmentMainBinding
import com.example.modularization.feature.main.impl.router.MainRouterFragmentFactory
import com.example.modularization.feature.main.impl.router.MainRouterImpl
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabSwitcherRouter
import com.example.modularization.feature.main.impl.router.tabSwitcher.TabSwitcherRouterNavigator
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