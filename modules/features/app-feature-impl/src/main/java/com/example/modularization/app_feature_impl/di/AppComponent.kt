package com.example.modularization.app_feature_impl.di

import android.content.Context
import com.example.modularization.app_feature_impl.activity.AppActivity
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        ChildComponentsFactoriesModule::class,
        AppModule::class
    ]
)
@PerApplicationScope
interface AppComponent {
    fun inject(activity: AppActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance context: Context
        ): AppComponent
    }
}


