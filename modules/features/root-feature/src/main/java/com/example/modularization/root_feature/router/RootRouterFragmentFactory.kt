package com.example.modularization.root_feature.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_api.RootRouter
import javax.inject.Inject

class RootRouterFragmentFactory @Inject constructor(
    private val rootRouterScreensResolver: RootRouter.ScreensResolver,
    private val rootRouterFragmentCreator: RootRouterFragmentCreator
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootRouterFragmentCreator.getFragmentByScreen(
            screen = rootRouterScreensResolver.getScreenByFragmentName(className)
        )
    }
}