package com.example.modularization.main_feature_impl.router

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.root_feature_data.MainRouter
import javax.inject.Inject

/**
 * Фабрика используется только при восстановлении фрагмента после его уничтожения системой для освобождения ресурсов.
 *      - сначала получаем Router.Screen из имени фрагмента
 *      - затем зная Router.Screen получаем инстанс фрагмента из RouterFragmentResolver
 * Навигатор не использует фабрику, а напрямую работает с RouterFragmentResolver
 */
class MainRouterFragmentFactory @Inject constructor(
    private val mainRouterScreensResolver: MainRouter.ScreensResolver,
    private val mainRouterFragmentResolver: MainRouterFragmentResolver
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return mainRouterFragmentResolver.getFragmentByScreen(
            screen = mainRouterScreensResolver.getScreenByFragmentName(className)
        )
    }
}