package com.example.modularization.root_feature_impl.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.employee_auth_feature_api.EmployeeAuthFeatureContract
import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.root_feature_data.RootRouter
import javax.inject.Inject

class RootRouterFragmentFactory @Inject constructor(
    private val employeeAuthFeatureComponentFactory: EmployeeAuthFeatureContract.ComponentFactory,
    private val mainFeatureComponentFactory: MainFeatureContract.ComponentFactory,
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
                            object : EmployeeAuthFeatureContract.Dependencies {
                                override fun rootRouter(): RootRouter = rootRouter
                            }
                        )

                        (fragment as EmployeeAuthFeatureContract.ComponentInjector).inject(component)
                    }

                    RootRouter.Screen.MainFeature.Main -> {
                        val component = mainFeatureComponentFactory.create(
                            object : MainFeatureContract.Dependencies {
                                override fun appRouter(): RootRouter = rootRouter
                            }
                        )

                        (fragment as MainFeatureContract.ComponentInjector).inject(component)
                    }
                }
            }
    }
}