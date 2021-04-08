package com.example.modularization.root_feature_data

import com.example.modularization.root_feature_data.RootRouter.*
import com.example.modularization.ui_core.CiceroneScreen


/**
 * Отвечает за контейнер расположденный в RootFragment.
 * Для добавления экрана нужно:
 *  1. Добавить новый [Screen]
 *  2. Добавить в реализацию [ScreenToNameMapper] обработку этого [Screen]
 *  3. Унаследовать новый экран от [ScreenFragment]
 *  4. Добавить обработку [Screen] в фабрику фрагментов в RootFragment
 */
interface RootRouter {

    fun navigateTo(screen: Screen)

    fun newRootScreen(screen: Screen)

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
     * Список экранов для навигации.
     */
    sealed class Screen : CiceroneScreen {
        sealed class EmployeeAuthFeature : Screen() {
            object Login : EmployeeAuthFeature()
            object DebugTools : EmployeeAuthFeature()
        }

        sealed class MainFeature : Screen() {
            object Main : MainFeature()
        }
    }
}

