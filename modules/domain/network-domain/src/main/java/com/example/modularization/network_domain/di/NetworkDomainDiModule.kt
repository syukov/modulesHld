package com.example.modularization.network_domain.di

import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.network_domain_api.models.Retrofit
import dagger.Module
import dagger.Provides

/**
 * Здесь описываем как DiComponent этого модуля будет получать сущности нужные для работы в этом модуле.
 * На вход provide методы могут получать как domainApi указанные в ApplicationScopeDependencies, так и что то локальное.
 */
@Module
class NetworkDomainDiModule {
    @ApplicationScope
    @Provides
    fun provideRetrofit(appDomainApi: AppDomainApi): Retrofit {
        return object : Retrofit(appDomainApi.appContext) {
            override fun <T> create(stub: () -> T): T {
                return stub()
            }
        }
    }
}