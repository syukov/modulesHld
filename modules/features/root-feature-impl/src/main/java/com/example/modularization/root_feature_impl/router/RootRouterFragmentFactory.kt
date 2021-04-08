package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject

class RootRouterFragmentFactory @Inject constructor(
    private val employeeAuthFeatureComponentFactory: EmployeeAuthFeatureLauncher.ComponentFactoryApi,
    private val mainFeatureComponentFactory: MainFeatureLauncher.ComponentFactoryApi,
    private val rootRouter: RootRouter
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return super.instantiate(classLoader, className)
            .also { fragment ->
                if (fragment !is RootRouter.ScreenFragment) {
                    throw UnsupportedOperationException("All fragment that are instantiated in app container should implement AppRouter.ScreenFragment")
                }

                when (fragment.getScreen()) {
                    is RootRouter.Screen.EmployeeAuthFeature -> {
                        val component = employeeAuthFeatureComponentFactory.create(
                            object : EmployeeAuthFeatureLauncher.Dependencies {
                                override fun rootRouter(): RootRouter = rootRouter
                            }
                        )

                        (fragment as EmployeeAuthFeatureLauncher.ComponentInjector).inject(component)
                    }

                    RootRouter.Screen.MainFeature.Main -> {
                        val component = mainFeatureComponentFactory.create(
                            object : MainFeatureLauncher.Dependencies {
                                override fun appRouter(): RootRouter = rootRouter
                            }
                        )

                        (fragment as MainFeatureLauncher.ComponentInjector).inject(component)
                    }
                }
            }
    }
}