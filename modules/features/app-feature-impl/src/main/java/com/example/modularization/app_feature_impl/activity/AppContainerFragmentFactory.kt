package com.example.modularization.app_feature_impl.activity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.app_feature_api.data.AppRouter
import com.example.modularization.employee_auth_feature_api.fature.EmployeeAuthFeatureContract
import javax.inject.Inject

class AppContainerFragmentFactory @Inject constructor(
    private val employeeAuthFeatureComponentFactory: EmployeeAuthFeatureContract.ComponentFactory,
    private val appRouter: AppRouter
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return super.instantiate(classLoader, className)
            .also { fragment ->
                if (fragment !is AppRouter.ScreenFragment) {
                    throw UnsupportedOperationException("All fragment that are instantiated in app container should implement AppRouter.ScreenFragment")
                }

                val screen = fragment.getScreen()
                when (screen) {
                    is AppRouter.Screen.EmployeeAuthFeature -> {
                        val component = employeeAuthFeatureComponentFactory.create(object :
                            EmployeeAuthFeatureContract.Dependencies {
                            override fun appRouter(): AppRouter = appRouter
                        })

                        (fragment as EmployeeAuthFeatureContract.ComponentInjector).inject(component)
                    }
                }

                if (screen is AppRouter.WithArg) {
                    fragment.arguments = screen.arg.toBundle()
                }
            }
    }
}