package com.example.modularization.app.impl.moduleApi

import android.content.Context
import com.example.modularization.app.api.moduleApi.AppDomainApi
import javax.inject.Inject


class AppDomainApiImpl @Inject constructor(
    override val appContext: Context
) : AppDomainApi