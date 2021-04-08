package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject

class RootRouterFragmentFactory @Inject constructor(
    private val rootRouterScreensResolver: RootRouter.ScreensResolver,
    private val rootRouterFragmentResolver: RootRouterFragmentResolver
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return rootRouterFragmentResolver.getFragmentByScreen(
            screen = rootRouterScreensResolver.getScreenByFragmentName(className)
        )
    }
}