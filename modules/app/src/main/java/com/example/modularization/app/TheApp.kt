package com.example.modularization.app

import android.app.Application
import com.example.modularization.app_api.AppComponentApiHolder
import com.example.modularization.di.AppComponent
import com.example.modularization.di.DaggerAppComponent

class TheApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(appContext = this)
        AppComponentApiHolder.componentApi = appComponent
    }
}