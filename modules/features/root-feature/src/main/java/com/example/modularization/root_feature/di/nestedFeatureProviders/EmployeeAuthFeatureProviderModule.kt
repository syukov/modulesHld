package com.example.modularization.root_feature.di.nestedFeatureProviders

import com.example.modularization.employee_auth_feature.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.employee_auth_feature.di.EmployeeAuthFeatureComponent
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
class EmployeeAuthFeatureProviderModule {
    @Provides
    fun provideComponent(
        rootRouter: RootRouter,
    ): EmployeeAuthFeatureComponent {
        return DaggerEmployeeAuthFeatureComponent.factory().create(
            object : EmployeeAuthFeatureComponent.Dependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        )
    }
}