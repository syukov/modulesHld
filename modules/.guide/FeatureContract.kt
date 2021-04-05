package com.example.modularization.xxx_feature_api

interface XXXFeatureContract {
    interface Dependencies {
        fun appRouter(): IAppRouter
    }

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
        fun childFeatureComponentFactory(): XXXFeatureContract.ComponentFactory

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



