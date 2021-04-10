package com.example.modularization.root_feature_impl.di.nestedFeatureProviders

import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.ui_core.di.PerFeatureScope
import dagger.Module
import dagger.Provides

@Module
class EmployeeAuthFeatureProviderModule {
    companion object {
        @Provides
        @PerFeatureScope
        fun provideFeatureComponentApi(
            factory: EmployeeAuthFeatureLauncher.ComponentFactoryApi,
            dependencies: EmployeeAuthFeatureLauncher.Dependencies
        ): EmployeeAuthFeatureLauncher.ComponentApi {
            return factory.create(dependencies)
        }

        @Provides
        fun provideComponentDependencies(
            rootRouter: RootRouter
        ): EmployeeAuthFeatureLauncher.Dependencies {
            return object : EmployeeAuthFeatureLauncher.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        }
    }
}