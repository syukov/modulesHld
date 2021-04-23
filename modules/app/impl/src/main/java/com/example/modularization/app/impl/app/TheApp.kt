package com.example.modularization.app.impl.app

import android.app.Application
import android.content.Context
import com.example.modularization.app.api.applicationScope.ApplicationScopeApiHolder
import com.example.modularization.app.api.moduleApi.AppDomainApi
import com.example.modularization.app.impl.di.AppDi
import com.example.modularization.app.impl.di.DaggerAppDi_DiComponent

class TheApp : Application() {
    companion object {
        lateinit var appComponent: AppDi.DiComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppDi_DiComponent.factory().create(
            object : AppDi.FactoryDependencies {
                override val appContext: Context = this@TheApp
            }
        )

        ApplicationScopeApiHolder.put(appComponent.appDomainApi, AppDomainApi::class.java)
    }
}