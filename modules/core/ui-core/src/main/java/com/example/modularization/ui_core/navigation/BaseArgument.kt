package com.example.modularization.ui_core.navigation

import android.os.Bundle
import android.os.Parcelable

interface BaseArgument : Parcelable {
    companion object {
        private const val key = "bundle.arg.key"
        fun extract(bundle: Bundle?): BaseArgument? {
            return bundle?.getParcelable(key)
        }
    }

    fun toBundle(): Bundle = Bundle().also { it.putParcelable(key, this) }
}