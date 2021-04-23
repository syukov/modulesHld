package com.example.modularization.domain.core.api.models.domainEvents

sealed class DomainEvent {
    object OnEmployeeLogout : DomainEvent()
}