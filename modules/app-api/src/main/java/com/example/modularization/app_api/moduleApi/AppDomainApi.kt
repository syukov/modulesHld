package com.example.modularization.app_api.moduleApi

import android.content.Context
import com.example.modularization.app_api.diDoc.Doc

@Doc.Api
interface AppDomainApi {
    val appContext: Context
}

