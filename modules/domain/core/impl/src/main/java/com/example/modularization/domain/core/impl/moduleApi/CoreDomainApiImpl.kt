package com.example.modularization.domain.core.impl.moduleApi

import com.example.modularization.domain.core.api.models.domainEvents.DomainEventsBus
import com.example.modularization.domain.core.api.moduleApi.CoreDomainApi
import javax.inject.Inject
import javax.inject.Provider


class CoreDomainApiImpl @Inject constructor(
    private val domainEventBusProvider: Provider<DomainEventsBus>
) : CoreDomainApi {
    override val domainEventBus: DomainEventsBus get() = domainEventBusProvider.get()
}