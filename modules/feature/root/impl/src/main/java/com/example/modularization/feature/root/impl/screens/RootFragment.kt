package com.example.modularization.feature.root.impl.screens

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.modularization.feature.core.impl.mvp.BaseFragment
import com.example.modularization.feature.core.impl.navigation.RouterNavigator
import com.example.modularization.feature.core.impl.navigation.navigatorHolder
import com.example.modularization.feature.root.api.RootRouter
import com.example.modularization.feature.root.impl.R
import com.example.modularization.feature.root.impl.databinding.FragmentRootBinding
import com.example.modularization.feature.root.impl.router.RootRouterFragmentCreator
import com.example.modularization.feature.root.impl.router.RootRouterFragmentFactory
import com.example.modularization.feature.root.impl.router.RootRouterImpl
import javax.inject.Inject

class RootFragment @Inject constructor(
    private var rootRouter: RootRouter,
    private var fragmentFactory: RootRouterFragmentFactory,
    private var rootRouterFragmentCreator: RootRouterFragmentCreator
) : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        childFragmentManager.fragmentFactory = fragmentFactory
        rootRouter.newRootScreen(RootRouter.Screen.EmployeeAuthFeature.Login)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return FragmentRootBinding.inflate(inflater).root
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
        (rootRouter as RootRouterImpl).navigatorHolder.setNavigator(
            RouterNavigator(rootRouterFragmentCreator, childFragmentManager, R.id.rootContainer)
        )
    }

    override fun onPause() {
        super.onPause()
        (rootRouter as RootRouterImpl).navigatorHolder.removeNavigator()
    }

    override fun onBackPressed(): Boolean {
        rootRouter.navigateBack()
        return true
    }
}