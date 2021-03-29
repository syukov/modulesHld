package com.example.modularization.di

import com.example.modularization.featureRoot.EmployeeAuthFeatureRootFragment
import com.example.modularization.publicContract.EmployeeAuthFeatureApi
import com.example.modularization.publicContract.EmployeeAuthFeatureDeps
import dagger.Component

@Component(
    dependencies = [EmployeeAuthFeatureDeps::class]
)
interface EmployeeAuthFeatureComponent : EmployeeAuthFeatureApi {

    fun inject(fragment: EmployeeAuthFeatureRootFragment)

    @Component.Factory
    interface ComponentFactory {
        fun create(
            deps: EmployeeAuthFeatureDeps
        ): EmployeeAuthFeatureComponent
    }
}