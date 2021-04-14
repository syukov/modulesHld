package com.example.modularization.network_domain_api.models

import android.content.Context

// stub
abstract class Retrofit(
    val context: Context
) {
    abstract fun <T> create(stub: () -> T): T
}