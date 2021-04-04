package com.example.modularization.publicContract

/**
 * Лежит в градл модуле :child-feature-api
 */
interface ChildFeatureContract {
    /**
     * Интерфейс описывающий необходимые сущьности которые нужны фиче извне.
     * Нам нужно предоставить набор этих сущностей в компонент фичи для того что бы даггер смог подставлять их в классы фичи.
     * Реальная имплементация этого интерфейса будет находиться в родительской фиче в FragmentFactory.
     */
    interface Dependencies {
        fun appRouter(): IAppRouter
        fun eventBus(): IEventBus
    }

    /**
     * Этот интерфейс наследуется только компонентом фичи.
     * Имплементация компонента находится в :child-feature-impl градл модуле и не видна из других модулей,
     * в то же время родительской фичи нужно уметь создавать компонент этой фичи,
     * значит она должна видеть какую то публичную абстракцию над реальным компонентом.
     */
    interface Component

    /**
     * Интерфейс позволяющий создать компонент.
     * Имплементация фабрики находится в :some-feature-impl градл модуле и не видна из других модулей,
     * в то же время родительской фичи нужно уметь создавать компонент этой фичи,
     * значит она должна видеть какую то публичную абстракцию над реальной фабрикой.
     */
    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    /**
     * Этот интерфейс наследуют фрагменты данной фичи.
     * Фрагменты должны содержать пустой конструктор, что бы FragmentFactory родительской фичи могла создать этот фрагмент.
     * После создания фрагмента FragmentFactory сразу передаст компонент фичи в фрагмент для того что бы он мог занжектить себе нужные поля класса.
     * Все необходимые зависимости во фрагменте провайдятся через @Inject поля класса.
     * Во фрагменте реализация этого метода [inject] выглядит слудующим образом:
     * ```
     *  inject(component: ChildFeatureContract.Component){
     *      (component as DaggerChildFeatureComponent).inject(this)
     *  }
     * ```
     */
    interface ComponentInjector {
        fun inject(component: Component)
    }
}

interface ParentFeatureContract {
    /**
     * Зависимости которые нужны дочерним фичам и не нужны самой родительской фиче описываются через Provider
     */
    interface Dependencies {
        /**
         *
         */
        fun appRouter(): IAppRouter

        /**
         * Родительская фича должна уметь вставить в конструктор своей FragmentFactory абрику создающую ChildFragment.
         */
        fun childFeatureComponentFactory(): ChildFeatureContract.ComponentFactory

        fun eventBusProvider: Provider<EventBus>
    }

    interface Component

    interface ComponentFactory {
        fun create(dependencies: Dependencies): Component
    }

    interface ComponentInjector {
        fun inject(component: Component)
    }
}



