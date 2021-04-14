package com.example.modularization.app_api.applicationScope

/**
 * Здесь храняться все DomainApi - они инициализируются при старте приложения и имеют глобальный скоуп.
 */
object ApplicationScopeApiHolder {
    private val map: MutableMap<Class<out Any>, Any> = mutableMapOf()

    fun <T : Any> put(impl: T, classOfApi: Class<T>) {
        map[classOfApi] = impl
    }

    @Suppress("UNCHECKED_CAST")
    fun <T> get(classOfApi: Class<T>): T {
        return map[classOfApi] as T
    }
}

