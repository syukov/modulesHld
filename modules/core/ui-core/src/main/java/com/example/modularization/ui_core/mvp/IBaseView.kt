package com.example.modularization.ui_core.mvp

import java.lang.ref.WeakReference

interface IBaseView {
    /**
     * Ссылки на текущие дочерние [IBaseView] в активном состоянии
     */
    val childViews: MutableList<WeakReference<IBaseView>>

    /**
     * Вызывается дочерними view при onResume.
     * Текущая view формирует новый [childViews].
     */
    fun rebuildChildTree() {
    }

    /**
     * Вызывается двумя путями:
     * - роутером контейнера в котором размещена текущая view когда он стартует транзакцию на смену фрагмента
     * - родительской view когда на ней самой вызван onLeave()
     *
     * В этот момент экран должен гарантированно остановить все свои юзкейсы.
     */
    fun onLeave() {
        childViews.forEach { it.get()?.onLeave() }
    }

    fun handleBackPressed(): Boolean {
        // сначала попробуем обработать событие дочерними view
        childViews.forEach { childRef ->
            val isHandled = childRef.get()?.handleBackPressed() ?: false
            if (isHandled) return true
        }
        // если дочерние view не обработали событие, то вызовем обработчик текущей view
        return onBackPressed()
    }

    /**
     * Обработка нажатия хардварной кнопки назад. Вызов этого метода произойдет только в случае если ни одна из дочерних
     * view не обработала это действие.
     * @return true если команда обработана
     */
    fun onBackPressed(): Boolean = false
}