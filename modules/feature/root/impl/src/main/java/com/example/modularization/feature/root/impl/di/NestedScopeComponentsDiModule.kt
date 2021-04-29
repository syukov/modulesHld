package com.example.modularization.feature.root.impl.di

import com.example.modularization.feature.employeeAuth.impl.di.DaggerEmployeeAuthFeatureDi_DiComponent
import com.example.modularization.feature.employeeAuth.impl.di.EmployeeAuthFeatureDi
import com.example.modularization.feature.main.impl.di.DaggerMainFeatureDi_DiComponent
import com.example.modularization.feature.main.impl.di.MainFeatureDi
import com.example.modularization.feature.root.api.RootRouter
import dagger.Module
import dagger.Provides

@Module
class NestedScopeComponentsDiModule {
    @Provides
    fun provideMainFeatureDiComponent(
        rootRouter: RootRouter,
    ): MainFeatureDi.DiComponent {
        return DaggerMainFeatureDi_DiComponent.factory().create(
            object : MainFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
            }
        )
    }

    @Provides
    fun provideEmployeeAuthFeatureDiComponent(
        rootRouter: RootRouter,
    ): EmployeeAuthFeatureDi.DiComponent {
        return DaggerEmployeeAuthFeatureDi_DiComponent.factory().create(
            object : EmployeeAuthFeatureDi.FactoryDependencies {
                override val rootRouter: RootRouter = rootRouter
            }
        )
    }
}