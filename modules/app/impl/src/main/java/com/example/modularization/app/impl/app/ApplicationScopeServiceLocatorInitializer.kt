package com.example.modularization.app.impl.app

import com.example.modularization.app.api.applicationScope.ApplicationScopeServiceLocator
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.app.impl.di.AppDi
import com.example.modularization.domain.cart.api.moduleApi.CartDomainApi
import com.example.modularization.domain.cart.impl.di.CartDomainDi
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import com.example.modularization.domain.core.impl.di.CoreDomainDi
import com.example.modularization.domain.network.api.moduleApi.NetworkDomainApi
import com.example.modularization.domain.network.impl.di.NetworkDomainDi
import com.example.modularization.domain.security.api.moduleApi.SecurityDomainApi
import com.example.modularization.domain.security.impl.di.SecurityDomainDi
import java.util.concurrent.atomic.AtomicBoolean
import javax.inject.Inject


/**
 * Здесь мы инициализируем все зависимости имеющие глобальный скоуп.
 *
 * Т.к. инстансы DomainApi создаются сразу и между ними есть зависимости (
 * т.е. юзкейсы одного domainApi могут вызывать второго domainApi, т.е. этот второй domainApi заинжекчен в юзкейс первого),
 * то в реализациях domainApi нужно все юзкейсы возвращать через провайдеры. Это для того что бы создание одного domainApi сразу
 * не приводило к созданию его юзкейсов, а следовательно не требовало бы созданного второго DomainApi.
 *
 * Это ограничение распространяется только на DomainApi (кроме AppDomainApi) из-за особенностей их инициализации (при старте приложения)
 */
class ApplicationScopeServiceLocatorInitializer @Inject constructor(
    private val appComponent: AppDi.DiComponent,
    private val coreDomainComponent: CoreDomainDi.DiComponent,

    private val networkDomainComponent: NetworkDomainDi.DiComponent,
    private val securityDomainComponent: SecurityDomainDi.DiComponent,
    private val cartDomainComponent: CartDomainDi.DiComponent,
) {
    companion object {
        private var isInitialized = AtomicBoolean(false)
    }

    fun init() {
        // инициализируем только один раз, метод вызывается из activity, а она может быть пересоздана, поэтому
        if (isInitialized.getAndSet(true)) return

        ApplicationScopeServiceLocator.apply {
            put(appComponent.appDomainApi, AppDomainApi::class.java)
            put(coreDomainComponent.coreDomainApi, CoreDomainApi::class.java)
            put(securityDomainComponent.securityDomainApi, SecurityDomainApi::class.java)
            put(cartDomainComponent.cartDomainApi, CartDomainApi::class.java)
            put(networkDomainComponent.networkDomainApi, NetworkDomainApi::class.java)
        }

        coreDomainComponent.coreDomainApi.domainEventBus.subscribe(
            cartDomainComponent.onDomainEventListener,
        )
    }
}