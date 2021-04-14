package com.example.modularization.moduleApi

import android.content.Context
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import javax.inject.Inject

@DiDoc.Api.Implementation
class AppDomainApiImpl @Inject constructor(
    override val appContext: Context
) : AppDomainApi