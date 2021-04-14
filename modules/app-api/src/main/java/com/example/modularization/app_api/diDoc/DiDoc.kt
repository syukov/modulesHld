package com.example.modularization.app_api.diDoc

/**
 * Эта аннотация помечает часто используемые элементы при описании di каждого градл-модуля.
 * Это необходимо что бы во всех модулях сохранялась одинаковый подход к di.
 *
 * В дальнейшем на основе этих аннотаций можно будет написать правило дял detekt.
 */
annotation class DiDoc {

    /**
     * Интерфейс в котором во вложенных интерфейсах описывается структура компонента текущего градл-модуля и его зависимости.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class Structure {
        /**
         * Интерфейс даггер компонента текущего градл-модуля.
         *
         * Должен наследовать ApplicationScopeDependencies.
         *
         * Должен включать в аннотации @Component dependencies = [FactoryDependencies::class].
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiComponent

        /**
         * Зависимости реализации которых предоставляются текущему даггер-компоненту через аргумент фабрики при его создании.
         *
         * Компонент должен включать в аннотации @Component (dependencies = [FactoryDependencies::class])
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class FactoryDependencies

        /**
         * Зависимости реализации которых текущий даггер-компонент может достать из ApplicationScopeApiHolder.
         *
         * Компонент должен наследовать ApplicationScopeDependencies, для того что бы уметь его предостаавлять классам текущего модуля.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class ApplicationScopeDependencies

        /**
         * Сущности реализации которых родительская фича может достать из текущего даггер-компонента.
         *
         * Компонент должен наследовать DiComponentInterface, что бы через его методы снаружи можно было вынуть нужные реализации.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiComponentInterface
    }

    /**
     * Интерфейс описывающий какую то сущность которую даггер-компонент умеет отдавать наружу,
     * т.е. то что описано в [DiDoc.Structure.DiComponentInterface].
     *
     * Чаще всего этот интерфейс лежит в отдельном апи-градл-модуле (например SecurityDomainApi, MainRouter, ...).
     *
     * Но это не обязательно, в случае если родительская фича хочет достать что то из компонента (например FragmentProvider)
     * и кроме родительской фичи этим никто не будет пользоваться, то не обязательно выносить Api в отдельный интерфейс.
     *
     * - Когда api создается при старте приложения и имеет ApplicationScope (например все DomainApi),
     * то его реализация доступна через ApplicationScopeApiHolder.
     * - Когда api создается в модуле и используется только им самим или его дочерними модулями (например роутеры),
     * то реализация передается в компоненты дочерних модулей через их FactoryDependencies.
     * - Когда api создается в модуле и используется только его родительским модулем (например FragmentProvider),
     * то родительский модуль может получить реализацию из самого компонента этого модуля.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class Api {
        /**
         * Реализация Api интерфейса этого градл-модуля которая будет доступна другим градл-модулям.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class Implementation

        /**
         * В этом даггер-модуле описываем как DiComponent будет создавать ApiImpl - реализацию Api.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiModule
    }

    /**
     * В этом даггер-модуле описываем как текущий даггер-компонент будет получать различные domainApi используемые в этом градл-модуле.
     *
     * Эти domainApi должны быть указаны в XxxDi.ApplicationScopeDependencies.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class ApplicationScopeDependenciesDiModule

    /**
     * Актуально для фиче-модулей.
     *
     * В текущем градл-модуле есть фрагмент с контейнером внетри которого можно запускать фрагменты других градл-модулей.
     * Значит, текущий даггер-компонент должен уметь создавать соответствующие даггер-компоненты.
     *
     * В этом даггер-модуле описываем создание этих даггер-компонентов.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class NestedScopeComponentsDiModule
}