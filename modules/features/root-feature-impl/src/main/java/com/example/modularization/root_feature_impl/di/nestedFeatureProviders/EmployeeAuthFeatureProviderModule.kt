package com.example.modularization.root_feature_impl.di.nestedFeatureProviders

import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.employee_auth_feature_impl.di.EmployeeAuthFeatureComponent
import com.example.modularization.root_feature_data.RootRouter
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