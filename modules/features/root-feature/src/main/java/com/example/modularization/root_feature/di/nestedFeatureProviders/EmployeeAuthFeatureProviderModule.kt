package com.example.modularization.root_feature.di.nestedFeatureProviders

import com.example.modularization.employee_auth_feature.di.DaggerEmployeeAuthFeatureDi_FeatureComponent
import com.example.modularization.employee_auth_feature.di.EmployeeAuthFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
class EmployeeAuthFeatureProviderModule {
    @Provides
    fun provideComponent(
        rootRouter: RootRouter,
    ): EmployeeAuthFeatureDi.FeatureComponent {
        return DaggerEmployeeAuthFeatureDi_FeatureComponent.factory().create(
            object : EmployeeAuthFeatureDi.FactoryDependencies {
                override fun rootRouter(): RootRouter = rootRouter
            }
        )
    }
}