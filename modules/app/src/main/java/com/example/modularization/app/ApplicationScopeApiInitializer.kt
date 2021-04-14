package com.example.modularization.app

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.network_domain.di.NetworkDomainDi
import com.example.modularization.network_domain_api.moduleApi.NetworkDomainApi
import com.example.modularization.security_domain.di.SecurityDomainDi
import com.example.modularization.security_domain_api.moduleApi.SecurityDomainApi
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject


/**
 * Здесь мы инициализируем все зависимости имеющие глобальный скоуп
 */
class ApplicationScopeApiInitializer @Inject constructor(
    private val networkDomainComponent: NetworkDomainDi.DiComponent,
    private val securityDomainComponent: SecurityDomainDi.DiComponent,
) {
    companion object {
        private var isInitialized = AtomicBoolean(false)
    }

    fun init() {
        // инициализируем только один раз, метод вызывается из activity, а она может быть пересоздана
        if (isInitialized.getAndSet(true)) return

        ApplicationScopeApiHolder.apply {
            put(networkDomainComponent.networkDomainApi, NetworkDomainApi::class.java)
            put(securityDomainComponent.securityDomainApi, SecurityDomainApi::class.java)
        }
    }
}