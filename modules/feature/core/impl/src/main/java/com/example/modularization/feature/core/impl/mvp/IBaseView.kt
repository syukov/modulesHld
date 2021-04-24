package com.example.modularization.feature.core.impl.mvp

import android.util.Log
import androidx.annotation.CallSuper
import java.lang.ref.WeakReference

interface IBaseView {
    /**
     * Ссылки на текущие дочерние [IBaseView] в активном состоянии (после хотя бы одного onResume() и до onLeave())
     */
    val childViews: MutableList<WeakReference<IBaseView>>

    /**
     * Вызывается дочерними [IBaseView] при onResume.
     * Текущая [IBaseView] формирует новый [childViews].
     */
    fun rebuildChildTree() {
    }

    /**
     * Вызывается двумя путями:
     * - роутером контейнера в котором размещена текущая [IBaseView] когда он стартует транзакцию на смену фрагмента или производит возврат по бэкстеку.
     * - родительской [IBaseView] когда на ней самой вызван onLeave()
     *
     * В этот момент экран должен гарантированно остановить все свои юзкейсы.
     */
    @CallSuper
    fun onLeave() {
        Log.d("qweqwe", "${this::class.java.simpleName} onLeave")
        childViews.forEach { it.get()?.onLeave() }
    }

    fun handleOnBackPressed(): Boolean {
        // сначала попробуем обработать событие дочерними view
        childViews.forEach { childRef ->
            val isHandled = childRef.get()?.handleOnBackPressed() ?: false
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