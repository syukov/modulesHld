package com.example.modularization.employee_auth_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [EmployeeAuthFeatureComponent.Dependencies::class],
    modules = [
        EmployeeAuthFeatureModule::class,
    ]
)
@PerFeatureScope
interface EmployeeAuthFeatureComponent {

    @Component.Factory
    interface ComponentFactory {
        fun create(dependencies: Dependencies): EmployeeAuthFeatureComponent
    }

    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
    }

    fun getFragmentProvider(): FragmentProvider

    interface Dependencies {
        fun rootRouter(): RootRouter
    }
}