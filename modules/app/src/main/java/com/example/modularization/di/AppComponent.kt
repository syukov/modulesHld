package com.example.modularization.di

import android.content.Context
import com.example.modularization.activity.AppActivity
import com.example.modularization.app_api.AppComponentApi
import com.example.modularization.di.nestedFeatureProviders.RootFeatureProviderModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        RootFeatureProviderModule::class,
    ]
)
@PerApplicationScope
interface AppComponent : AppComponentApi {
    fun inject(activity: AppActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance appContext: Context
        ): AppComponent
    }

    // AppComponentApi:
    override fun appContext(): Context
}


