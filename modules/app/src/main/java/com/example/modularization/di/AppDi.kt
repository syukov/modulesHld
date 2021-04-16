package com.example.modularization.di

import android.content.Context
import com.example.modularization.activity.AppActivity
import com.example.modularization.app_api.applicationScope.ApplicationScope
import com.example.modularization.app_api.diDoc.Doc
import com.example.modularization.app_api.moduleApi.AppDomainApi
import com.example.modularization.moduleApi.AppDomainApiDiModule
import dagger.Component


@Doc.Structure
interface AppDi {
    @Component(
        dependencies = [FactoryDependencies::class],
        modules = [
            AppDomainApiDiModule::class,
            NestedScopeComponentsDiModule::class,
        ]
    )
    @ApplicationScope
    @Doc.Structure.DiComponent
    interface DiComponent : ApplicationScopeDependencies, DiComponentInterface {
        fun inject(activity: AppActivity)

        @Component.Factory
        interface Factory {
            fun create(
                dependencies: FactoryDependencies
            ): DiComponent
        }
    }

    @Doc.Structure.FactoryDependencies
    interface FactoryDependencies {
        val appContext: Context
    }

    @Doc.Structure.ApplicationScopeDependencies
    interface ApplicationScopeDependencies {
        /* no-op */
    }

    @Doc.Structure.DiComponentInterface
    interface DiComponentInterface {
        val appDomainApi: AppDomainApi
    }
}



