package com.example.modularization.core_domain_api.models.domainEvents

sealed class DomainEvent {
    object OnEmployeeLogout : DomainEvent()
}