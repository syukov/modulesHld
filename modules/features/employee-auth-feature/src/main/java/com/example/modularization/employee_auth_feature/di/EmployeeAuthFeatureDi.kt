package com.example.modularization.employee_auth_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature_api.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component


interface EmployeeAuthFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [EmployeeAuthFeatureModule::class]
    )
    @PerFeatureScope
    interface FeatureComponent : GlobalDependencies {

        @Component.Factory
        interface ComponentFactory {
            fun create(dependencies: FactoryDependencies): FeatureComponent
        }

        fun getFragmentProvider(): FragmentProvider
    }

    interface FragmentProvider {
        fun getFragment(screen: RootRouter.Screen.EmployeeAuthFeature): Fragment
    }

    interface FactoryDependencies {
        val rootRouter: RootRouter
    }

    interface GlobalDependencies {
        /* no-op */
    }
}

