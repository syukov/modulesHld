package com.example.modularization.root_feature.di

import androidx.fragment.app.Fragment
import com.example.modularization.root_feature.di.nestedFeatureProviders.EmployeeAuthFeatureProviderModule
import com.example.modularization.root_feature.di.nestedFeatureProviders.MainFeatureProviderModule
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Component

@Component(
    dependencies = [RootFeatureComponent.Dependencies::class],
    modules = [
        RootRouterModule::class,
        RootFeatureModule::class,
        EmployeeAuthFeatureProviderModule::class,
        MainFeatureProviderModule::class,
    ]
)
@PerFeatureScope
interface RootFeatureComponent {
    @Component.Factory
    interface ComponentFactory {
        fun create(dependencies: Dependencies): RootFeatureComponent
    }

    interface FragmentProvider {
        fun getRootFragment(): Fragment
    }

    fun getFragmentProvider(): FragmentProvider

    interface Dependencies {
        /* no-op */
    }
}