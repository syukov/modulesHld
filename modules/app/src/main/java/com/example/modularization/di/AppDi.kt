package com.example.modularization.di

import android.content.Context
import com.example.modularization.activity.AppActivity
import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.DiDoc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.moduleApi.AppDomainApiDiModule
import dagger.Component


@DiDoc.Structure
interface AppDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            AppDomainApiDiModule::class,
            NestedScopeComponentsDiModule::class,
        ]
    )
    @ApplicationScope
    @DiDoc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun inject(activity: AppActivity)

        @Component.Factory
        interface Factory {
            fun create(
                dependencies: FactoryDependencies
            ): DiComponent
        }
    }

    @DiDoc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val appContext: Context
    }

    @DiDoc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @DiDoc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val domainApi: AppDomainApi
    }
}



