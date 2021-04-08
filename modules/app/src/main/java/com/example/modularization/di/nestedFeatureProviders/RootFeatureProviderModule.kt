package com.example.modularization.di.nestedFeatureProviders

import android.content.Context
import com.example.modularization.di.PerApplicationScope
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_data.RootRouter
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import dagger.Module
import dagger.Provides


/**
 * Если фича создает и запускает внутри себя другие фичи, то в родительской фиче в даггер-модуле мы прописывааем:
 * 1) Создание имплементации FeatureLauncher.Dependencies дочерней фичи.
 *    Родительская фича должна уметь предоставлять эти зависимости создавая их внутри себя ии беря их от своей родительской фичи.
 * 2) Создание дочернего компонента с помощью фабрики и зависимостей.
 */
@Module
interface RootFeatureProviderModule {
    companion object {
        @Provides
        @PerApplicationScope
        fun provideRootComponentApi(
            factory: RootFeatureLauncher.ComponentFactoryApi,
            dependencies: RootFeatureLauncher.Dependencies
        ): RootFeatureLauncher.ComponentApi {
            return factory.create(dependencies)
        }

        @Provides
        fun provideRootComponentDependencies(
            appContext: Context,
            rootRouterScreenResolver: RootRouter.ScreensResolver,
            employeeAuthFeatureContractComponentFactory: EmployeeAuthFeatureLauncher.ComponentFactoryApi,
            mainFeatureContractComponentFactory: MainFeatureLauncher.ComponentFactoryApi,
        ): RootFeatureLauncher.Dependencies {
            return object : RootFeatureLauncher.Dependencies {
                override fun rootRouterScreenResolver(): RootRouter.ScreensResolver =
                    rootRouterScreenResolver

                override fun appContext(): Context = appContext

                override fun employeeAuthFeatureComponentFactoryApi(): EmployeeAuthFeatureLauncher.ComponentFactoryApi =
                    employeeAuthFeatureContractComponentFactory

                override fun mainFeatureComponentFactoryApi(): MainFeatureLauncher.ComponentFactoryApi =
                    mainFeatureContractComponentFactory
            }
        }
    }
}