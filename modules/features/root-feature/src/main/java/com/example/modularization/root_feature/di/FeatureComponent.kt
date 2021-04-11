package com.example.modularization.root_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature.di.nestedFeatureProviders.EmployeeAuthFeatureProviderModule
import com.example.modularization.root_feature.di.nestedFeatureProviders.MainFeatureProviderModule
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

interface RootFeatureDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            RootRouterModule::class,
            RootFeatureModule::class,
            // TODO: добавляем сюда модули умеющие создавать компоненты вложенных фич
            EmployeeAuthFeatureProviderModule::class,
            MainFeatureProviderModule::class,
        ]
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
        fun getRootFragment(): Fragment
    }

    interface FactoryDependencies {
        /* no-op */
    }

    interface GlobalDependencies {
        /* no-op */
    }
}