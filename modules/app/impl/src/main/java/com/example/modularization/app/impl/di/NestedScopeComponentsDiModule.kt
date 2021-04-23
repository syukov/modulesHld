package com.example.modularization.app.impl.di

import com.example.modularization.app.api.applicationScope.ApplicationScope
import com.example.modularization.app.api.diDoc.Doc
import com.example.modularization.domain.cart.impl.di.CartDomainDi
import com.example.modularization.domain.cart.impl.di.DaggerCartDomainDi_DiComponent
import com.example.modularization.domain.core.impl.di.CoreDomainDi
import com.example.modularization.domain.core.impl.di.DaggerCoreDomainDi_DiComponent
import com.example.modularization.domain.network.impl.di.DaggerNetworkDomainDi_DiComponent
import com.example.modularization.domain.network.impl.di.NetworkDomainDi
import com.example.modularization.domain.security.impl.di.DaggerSecurityDomainDi_DiComponent
import com.example.modularization.domain.security.impl.di.SecurityDomainDi
import com.example.modularization.root_feature.di.DaggerRootFeatureDi_DiComponent
import com.example.modularization.root_feature.di.RootFeatureDi
import dagger.Module
import dagger.Provides


@Module
@Doc.NestedScopeComponentsDiModule
class NestedScopeComponentsDiModule {
    // Root Feature Module ---------------------------------------------------------------------------------------------
    @Provides
    @ApplicationScope
    fun provideComponent(
    ): RootFeatureDi.DiComponent {
        return DaggerRootFeatureDi_DiComponent.factory().create(
            object : RootFeatureDi.FactoryDependencies {}
        )
    }

    // All Domain Modules ----------------------------------------------------------------------------------------------

    @Provides
    @ApplicationScope
    fun coreDomainComponent(
    ): CoreDomainDi.DiComponent {
        return DaggerCoreDomainDi_DiComponent.factory().create(
            object : CoreDomainDi.FactoryDependencies {
            }
        )
    }

    @Provides
    @ApplicationScope
    fun networkDomainComponent(
    ): NetworkDomainDi.DiComponent {
        return DaggerNetworkDomainDi_DiComponent.factory().create(
            object : NetworkDomainDi.FactoryDependencies {
            }
        )
    }

    @Provides
    @ApplicationScope
    fun provideSecurityDomainComponent(
    ): SecurityDomainDi.DiComponent {
        return DaggerSecurityDomainDi_DiComponent.factory().create(
            object : SecurityDomainDi.FactoryDependencies {
            }
        )
    }

    @Provides
    @ApplicationScope
    fun provideCartDomainComponent(
    ): CartDomainDi.DiComponent {
        return DaggerCartDomainDi_DiComponent.factory().create(
            object : CartDomainDi.FactoryDependencies {
            }
        )
    }
}