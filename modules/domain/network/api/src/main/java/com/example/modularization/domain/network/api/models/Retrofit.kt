package com.example.modularization.domain.network.api.models

import android.content.Context

// stub
abstract class Retrofit(
    val context: Context
) {
    abstract fun <T> stub(stub: () -> T): T
}