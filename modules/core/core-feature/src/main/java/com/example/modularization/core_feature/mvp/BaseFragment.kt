package com.example.modularization.core_feature.mvp

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import com.example.modularization.core_domain_api.UseCase
import com.example.modularization.core_feature_api.navigation.BaseArgument
import java.lang.ref.WeakReference
import java.util.*

abstract class BaseFragment : Fragment(), IBaseView {
    override val childViews: MutableList<WeakReference<IBaseView>> = mutableListOf()

    companion object {
        private const val TAG = "LifecycleLog"
    }

    private val uid = UUID.randomUUID().toString().take(3)

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
        Log.d(TAG, "onCreate: ${this::class.java.simpleName}_$uid")
        BaseArgument.extract(arguments)?.let { onArgument(it) }
    }

    open fun onArgument(arg: BaseArgument) {
        /* no-op */
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d(TAG, "onViewCreated: ${this::class.java.simpleName}_$uid")
    }

    @CallSuper
    override fun onResume() {
        Log.d(TAG, "onResume: ${this::class.java.simpleName}_$uid")
        super.onResume()
        (parentFragment as? IBaseView)?.rebuildChildTree()
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: ${this::class.java.simpleName}_$uid")
    }

    override fun onLeave() {
        super.onLeave()
        Log.d(TAG, "onLeave: ${this::class.java.simpleName}_$uid")
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

    fun <A, R> runCase(case: UseCase<A, R>, arg: A, onSuccess: (R) -> Unit) {
        onSuccess(case(arg))
    }
}