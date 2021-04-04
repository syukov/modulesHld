package com.example.modularization.app_feature_impl.app

import android.app.Application
import com.example.modularization.app_feature_impl.di.AppComponent
import com.example.modularization.app_feature_impl.di.DaggerAppComponent

class TheApp : Application() {
    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this)
    }
}