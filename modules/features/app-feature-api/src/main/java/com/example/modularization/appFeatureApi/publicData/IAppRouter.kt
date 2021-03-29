package com.example.modularization.appFeatureApi.publicData

interface IAppRouter {
    fun navigate(command: AppRouterCommand)
}

sealed class AppRouterCommand {
    object Back : AppRouterCommand()
    data class Forward(val screen: AppRouterScreenKey) : AppRouterCommand()
}


/**
 * Все рутовые фрагменты фич которые будут размещаться в app онтейнере должны имплементить этот интерфейс.
 * Фабрика фрагментов app контейнера создаст фрагмент по его имени.
 * В звисимости от AppRouterScreen фабрика создаст апи фичи (компонент).
 * Фобрика инициирует фрагмент с помощью апи.
 */
interface AppRouterScreen {
    fun getAppRouterScreenProperties(): Properties

    data class Properties(
        val screenKey: AppRouterScreenKey,
        val rootFragmentClassName: String
    )
}

sealed class AppRouterScreenKey {
    object EmployeeAuth : AppRouterScreenKey()
}