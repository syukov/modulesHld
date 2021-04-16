package com.example.modularization.app_api.diDoc

/**
 * Эта аннотация помечает часто используемые элементы при описании di каждого градл-модуля.
 * Это необходимо что бы во всех модулях сохранялась одинаковый подход к di.
 *
 * В дальнейшем на основе этих аннотаций можно будет написать правило дял detekt.
 */
annotation class Doc {

    /**
     * Интерфейс в котором во вложенных интерфейсах описывается структура компонента текущего градл-модуля и его зависимости.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class Structure {
        /**
         * Интерфейс даггер компонента текущего градл-модуля.
         *
         * Должен наследовать [Structure.ApplicationScopeDependencies] (для того что бы автоматом проверялось что этот компонент может предоставить реализации указанных зависимостей).
         * Должен наследовать [Structure.DiComponentInterface] (для того что бы родительская фича могда достать то что ей нужно из компонента).
         *
         * Должен включать в аннотации @Component dependencies = [[Structure.FactoryDependencies]::class].
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiComponent

        /**
         * Зависимости реализации которых предоставляются текущему даггер-компоненту через аргумент фабрики при его создании.
         *
         * Компонент должен включать в аннотации @Component (dependencies = [[Structure.FactoryDependencies]::class])
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class FactoryDependencies

        /**
         * Зависимости реализации которых текущий даггер-компонент может достать из ApplicationScopeApiHolder.
         *
         * Компонент должен наследовать [Structure.ApplicationScopeDependencies], для того что бы уметь предостаавлять
         * эти зависимости классам текущего модуля.
         *
         * То как текущий компонент получает реализации этих зависимостей описано в даггер-модуле, помеченном анатацией [ApplicationScopeDependenciesDiModule].
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class ApplicationScopeDependencies

        /**
         * Сущности создающиеся внутри компонента и реализации которых родительская фича может достать из текущего даггер-компонента.
         *
         * Компонент должен наследовать DiComponentInterface, что бы через его методы снаружи можно было вынуть нужные реализации.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiComponentInterface
    }

    /**
     * Интерфейс описывающий какую то сущность которую даггер-компонент умеет отдавать наружу,
     * т.е. то что описано в [Doc.Structure.DiComponentInterface].
     *
     * Чаще всего этот интерфейс лежит в отдельном апи-градл-модуле (например SecurityDomainApi, MainRouter, ...).
     *
     * Но это не обязательно, в случае если родительская фича хочет достать что то из компонента (например FragmentProvider)
     * и кроме родительской фичи этим никто не будет пользоваться, то не обязательно выносить Api в отдельный интерфейс.
     *
     * - Когда реализация api создается при старте приложения и имеет ApplicationScope (например все DomainApi),
     * то она доступна через ApplicationScopeApiHolder.
     * - Когда реализация api создается в градл-модуле и используется только им самим или его дочерними градл-модулями (например роутеры),
     * то она передается в компоненты дочерних модулей через их [Structure.FactoryDependencies].
     * - Когда реализация api создается в градл-модуле и используется только его родительским градл-модулем (например FragmentProvider),
     * то родительский модуль может получить реализацию из самого компонента этого модуля через [Structure.DiComponentInterface].
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class Api {
        /**
         * Реализация Api интерфейса этого градл-модуля которая будет доступна другим градл-модулям.
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class Implementation

        /**
         * В этом даггер-модуле описываем как DiComponent будет создавать ApiImpl
         */
        @Retention(AnnotationRetention.SOURCE)
        annotation class DiModule
    }

    /**
     * В этом даггер-модуле описываем как текущий даггер-компонент будет получать различные domainApi используемые в этом градл-модуле.
     *
     * Эти domainApi должны быть указаны в [Structure.ApplicationScopeDependencies]
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class ApplicationScopeDependenciesDiModule

    /**
     * Актуально для фиче-модулей.
     *
     * В текущем градл-модуле есть фрагмент с контейнером внутри которого можно запускать фрагменты других градл-модулей.
     * Значит, текущий даггер-компонент должен уметь создавать соответствующие даггер-компоненты.
     *
     * В этом даггер-модуле описываем создание этих даггер-компонентов.
     */
    @Retention(AnnotationRetention.SOURCE)
    annotation class NestedScopeComponentsDiModule
}