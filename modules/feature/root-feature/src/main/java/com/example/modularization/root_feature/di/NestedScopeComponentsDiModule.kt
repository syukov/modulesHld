package com.example.modularization.root_feature.di

import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.employee_auth_feature.di.DaggerEmployeeAuthFeatureDi_DiComponent
import com.example.modularization.employee_auth_feature.di.EmployeeAuthFeatureDi
import com.example.modularization.main_feature.di.DaggerMainFeatureDi_DiComponent
import com.example.modularization.main_feature.di.MainFeatureDi
import com.example.modularization.root_feature_api.RootRouter
import dagger.Module
import dagger.Provides

@Module
@Doc.NestedScopeComponentsDiModule
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