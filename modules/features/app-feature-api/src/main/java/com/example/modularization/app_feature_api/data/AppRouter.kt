package com.example.modularization.app_feature_api.data

import com.example.modularization.app_feature_api.data.AppRouter.*
import com.example.modularization.ui_core.BaseArgument

typealias CiceroneScreen = com.github.terrakok.cicerone.Screen
typealias CiceroneCommand = com.github.terrakok.cicerone.Command

/**
 * Отвечает за контейнер расположденный в AppActivity.
 * Для добавления экрана нужно:
 *  1. Добавить новый [Screen]
 *  2. Добавить в реализацию [ScreenToNameMapper] обработку этого [Screen]
 *  3. Унаследовать новый экран от [ScreenFragment]
 *  4. Добавить обработку [Screen] в фабрику фрагментов в AppActivity
 */
interface AppRouter {
    fun navigate(command: Command)

    sealed class Command : CiceroneCommand {
        object Back : Command()
        data class BackTo(val screen: Screen?) : Command()
        data class Forward(val screen: Screen, val clearContainer: Boolean = true) : Command()
        data class Replace(val screen: Screen) : Command()
        data class ReplaceRoot(val screen: Screen) : Command() {
            fun getCommands() = arrayOf(BackTo(null), Replace(screen))
        }
    }

    /**
     * Этот интерфейс нужен для того что бы не дублировать логику создания фрагментов в фабрике и в роутере.
     * Т.к. контракт фабрики фрагментов (по имени класса должны отдать фрагмент), то приведем создание
     * фрагмента по ScreenKey к тому же случаю. Получим из ScreenKey имя класса фрагмента и отдадим его фобрике.
     */
    interface ScreenToNameMapper {
        fun getFragmentName(key: Screen): String
    }


    /**
     * Этот интерфейс наследуют фрагменты дочерних фич. Нужен для того что бы после создания фрагментов фабрикой
     * можно было понять к какому комоненту относится этот фрагмент.
     */
    interface ScreenFragment {
        fun getScreen(): Screen
    }


    /**
     * Список экранов для навигации. Если нужно что бы фрагмент принимал аргумент, то
     * создаем [Screen] как дата класс наследующий [WithArg] в котором лежит нужный аргумент.
     * Фабрика фрагментов посмотрит [Screen] и если он наследует [WithArg], то положит этот аргумент во фрагмент.
     */
    sealed class Screen : CiceroneScreen {
        sealed class EmployeeAuthFeature : Screen() {
            object Login : EmployeeAuthFeature()
            object DebugTools : EmployeeAuthFeature()
        }
    }

    interface WithArg {
        val arg: BaseArgument
    }
}

