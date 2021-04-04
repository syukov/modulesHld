package com.example.modularization.ui_core.mvp

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.modularization.ui_core.BaseArgument

open class BaseFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        BaseArgument.extract(arguments)?.let { onArgument(it) }
    }

    open fun onArgument(arg: BaseArgument) {

    }
}