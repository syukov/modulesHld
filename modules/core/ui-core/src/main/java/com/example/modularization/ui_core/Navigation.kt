package com.example.modularization.ui_core

import android.os.Bundle
import android.os.Parcelable

typealias CiceroneScreen = com.github.terrakok.cicerone.Screen
typealias CiceroneCommand = com.github.terrakok.cicerone.Command

interface BaseArgument : Parcelable {
    companion object {
        private const val key = "bundle.arg.key"
        fun extract(bundle: Bundle?): BaseArgument? {
            return bundle?.getParcelable(key)
        }
    }

    fun toBundle(): Bundle = Bundle().also { it.putParcelable(key, this) }
}