package com.example.modularization.app_feature_impl.di

import com.example.modularization.employee_auth_feature_api.EmployeeAuthFeatureContract
import com.example.modularization.employee_auth_feature_impl.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.main_feature_api.MainFeatureContract
import com.example.modularization.main_feature_impl.di.DaggerMainFeatureComponent
import com.example.modularization.root_feature_api.RootFeatureContract
import com.example.modularization.root_feature_impl.di.DaggerRootFeatureComponent
import dagger.Module
import dagger.Provides

/**
 * В этом даггер-модуле мы прописываем фабрики всех компонентов для всех фич.
 * Это нужно делать в :app т.к. отсюда нам видны все градл-модули приложения.
 *
 * Один инстанс фабрики создает только один экземпляр компонента и при последующих вызовах возвращает его же.
 * Это нужно для того что бы при создании фрагментов одного градл-модуля в рамках одного родительского контейнера
 * не пересоздавался компонент этого модуля.
 *
 * Но, в то же время, каждый модуль может иметь по своему инстансу фабрики.
 */
@Module
interface AllComponentsFactoriesModule {
    companion object {

        @Provides
        fun provideRootComponentFactory(): RootFeatureContract.ComponentFactory {
            return object : RootFeatureContract.ComponentFactory {
                lateinit var dependencies: RootFeatureContract.Dependencies
                val component by lazy { DaggerRootFeatureComponent.factory().create(dependencies) }

                override fun create(dependencies: RootFeatureContract.Dependencies): RootFeatureContract.Component {
                    this.dependencies = dependencies
                    return component
                }
            }
        }

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

        @Provides
        fun provideMainComponentFactory(): MainFeatureContract.ComponentFactory {
            return object : MainFeatureContract.ComponentFactory {
                lateinit var dependencies: MainFeatureContract.Dependencies
                val component by lazy { DaggerMainFeatureComponent.factory().create(dependencies) }

                override fun create(dependencies: MainFeatureContract.Dependencies): MainFeatureContract.Component {
                    this.dependencies = dependencies
                    return component
                }
            }
        }
    }
}