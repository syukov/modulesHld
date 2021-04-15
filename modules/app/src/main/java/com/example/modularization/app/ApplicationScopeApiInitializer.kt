package com.example.modularization.app

import com.example.modularization.app_api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.cart_domain.di.CartDomainDi
import com.example.modularization.cart_domain_api.moduleApi.CartDomainApi
import com.example.modularization.di.AppDi
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
    private val appComponent: AppDi.DiComponent,
    private val networkDomainComponent: NetworkDomainDi.DiComponent,
    private val securityDomainComponent: SecurityDomainDi.DiComponent,
    private val cartDomainComponent: CartDomainDi.DiComponent,
) {
    companion object {
        private var isInitialized = AtomicBoolean(false)
    }

    fun init() {
        // инициализируем только один раз, метод вызывается из activity, а она может быть пересоздана
        if (isInitialized.getAndSet(true)) return

        ApplicationScopeApiHolder.apply {
            put(appComponent.domainApi, AppDomainApi::class.java)
            put(networkDomainComponent.networkDomainApi, NetworkDomainApi::class.java)
            put(cartDomainComponent.cartDomainApi, CartDomainApi::class.java)
            put(securityDomainComponent.securityDomainApi, SecurityDomainApi::class.java)
        }
    }
}