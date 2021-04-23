package com.example.modularization.app.api.moduleApi

import android.content.Context
import com.example.modularization.app.api.diDoc.Doc

@Doc.Api
interface AppDomainApi {
    val appContext: Context
}

