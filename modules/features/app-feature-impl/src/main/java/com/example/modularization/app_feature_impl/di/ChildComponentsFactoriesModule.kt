package com.example.modularization.app_feature_impl.di

import com.example.modularization.employee_auth_feature_api.fature.EmployeeAuthFeatureContract
import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import dagger.Module
import dagger.Provides

/**
 * В этом модуле мы прописываем фабрики всех компонентов для всех фич.
 * Один инстанс фабрики создает только один экземпляр компонента и при последующих вызовах возвращает его же.
 * Это нужно для того что бы при создании фрагментов одного градл-модуля в рамках одного родительского контейнера
 * не пересоздавался компонент этого модуля.
 *
 * Но, в то же время, каждый модуль может иметь по своему инстансу фабрики.
 */
@Module
interface ChildComponentsFactoriesModule {
    companion object {

        @Provides
        fun provideEmployeeAuthComponentFactory(): EmployeeAuthFeatureContract.ComponentFactory {
            return object : EmployeeAuthFeatureContract.ComponentFactory {
                lateinit var dependencies: EmployeeAuthFeatureContract.Dependencies
                val component by lazy { DaggerEmployeeAuthFeatureComponent.factory().create(dependencies) }

                override fun create(dependencies: EmployeeAuthFeatureContract.Dependencies): EmployeeAuthFeatureContract.Component {
                    this.dependencies = dependencies
                    return component
                }
            }
        }
    }
}