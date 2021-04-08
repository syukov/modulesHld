package com.example.modularization.di.entireAppDependencies

import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.employee_auth_feature_launcher.EmployeeAuthFeatureLauncher
import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.main_feature_launcher.MainFeatureLauncher
import com.example.modularization.root_feature_impl.di.DaggerRootFeatureComponent
import com.example.modularization.root_feature_launcher.RootFeatureLauncher
import dagger.Module
import dagger.Provides

/**
 * В этом даггер-модуле мы прописываем фабрики всех компонентов в приложении.
 * Это нужно делать в :app т.к. только отсюда нам видны все градл-модули приложения.
 */
@Module
interface ComponentFactoryApiModule {
    companion object {

        @Provides
        fun provideRootComponentFactoryApi(): RootFeatureLauncher.ComponentFactoryApi =
            DaggerRootFeatureComponent.factory()

        @Provides
        fun provideEmployeeAuthComponentFactoryApi(): EmployeeAuthFeatureLauncher.ComponentFactoryApi =
            DaggerEmployeeAuthFeatureComponent.factory()

        @Provides
        fun provideMainComponentFactoryApi(): MainFeatureLauncher.ComponentFactoryApi =
            DaggerMainFeatureComponent.factory()
    }
}