package com.example.modularization.root_feature.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.modularization.root_feature.R
import com.example.modularization.root_feature.databinding.FragmentRootBinding
import com.example.modularization.root_feature.router.RootRouterFragmentFactory
import com.example.modularization.root_feature.router.RootRouterNavigator
import com.example.modularization.root_feature_api.RootRouter
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
        rootRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.Login)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentRootBinding.inflate(inflater).root.also {
            navigator = navigatorFactory.create(this, R.id.rootContainer)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        requireActivity().onBackPressedDispatcher.addCallback(
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    this@RootFragment.handleOnBackPressed()
                }
            }
        )
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

    override fun onBackPressed(): Boolean {
        rootRouter.navigateBack()
        return true
    }
}