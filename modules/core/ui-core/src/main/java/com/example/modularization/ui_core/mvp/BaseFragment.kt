package com.example.modularization.ui_core.mvp

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.example.modularization.ui_core.BaseArgument
import java.lang.ref.WeakReference

abstract class BaseFragment : Fragment(), IBaseView {
    override val childViews: MutableList<WeakReference<IBaseView>> = mutableListOf()

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseArgument.extract(arguments)?.let { onArgument(it) }
    }

    open fun onArgument(arg: BaseArgument) {
        /* no-op */
    }

    @CallSuper
    override fun onResume() {
        super.onResume()
        (parentFragment as? IBaseView)?.rebuildChildTree()
    }

    override fun rebuildChildTree() {
        // Базовая реализация для случаев когда [childViews] являются фрагментами
        childViews.clear()
        childViews.addAll(
            childFragmentManager.fragments
                .filter { it.isResumed }
                .filterIsInstance<IBaseView>()
                .map { WeakReference(it) }
        )
    }
}