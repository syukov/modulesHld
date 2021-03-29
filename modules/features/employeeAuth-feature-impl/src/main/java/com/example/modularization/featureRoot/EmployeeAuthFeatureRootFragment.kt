package com.example.modularization.featureRoot

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.appFeatureApi.publicData.AppRouterScreen
import com.example.modularization.appFeatureApi.publicData.AppRouterScreenKey
import com.example.modularization.di.EmployeeAuthFeatureComponent
import com.example.modularization.publicContract.EmployeeAuthFeatureApi
import com.example.modularization.publicContract.EmployeeAuthFeatureInitializer
import javax.inject.Inject

/**
 * Процесс восстановления после того как активити была пересоздана:
 * - в фабрике фрагментов контейнера в котором запускается фича у нас есть только имя класса [EmployeeAuthFeatureRootFragment]
 * - фабрика создает фрагмент через дефолтный конструктор (!!! e FeatureRootFragment не должно быть конструкторов с параметрами)
 * - фабрика проверяет является ли этот фрагмент AppRouterScreen
 * - если да, то в зависимости от того какой это AppRouterScreenKey:
 *      - кастит этот фрагмент к нужному XXXFeatureInitializer (в данном случае это EmployeeAuthFeatureInitializer, который лежит в модуле :employeeAuth-feature-api)
 *      - создает компонент апи фичи (компонент) (в данном случае это EmployeeAuthFeatureApi)
 * - затем фабрика вызывает [EmployeeAuthFeatureInitializer.initFeature] передавая в аргумент апи (компонент)
 * - готово: у нас есть рутовый фрагмент фичи, с сохраненным в нем компонентом этой фичи. Дальше он внутри себя создает фрагмент фактори фичи и устанавливает нужный фрагмент в свой контейнер.
 */
class EmployeeAuthFeatureRootFragment : Fragment(),
    EmployeeAuthFeatureInitializer,
    AppRouterScreen {

    private lateinit var featureComponent: EmployeeAuthFeatureComponent

    override fun getAppRouterScreenProperties() = AppRouterScreen.Properties(
        screenKey = AppRouterScreenKey.EmployeeAuth,
        rootFragmentClassName = this::class.java.name
    )

    override fun initFeature(api: EmployeeAuthFeatureApi) {
        featureComponent = api as EmployeeAuthFeatureComponent
        featureComponent.inject(this)
    }

    @Inject
    lateinit var featureFragmentFactory: FeatureFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = featureFragmentFactory
    }
}

class FeatureFragmentFactory @Inject constructor(
//    private val profileNavigationBottomSheet: Provider<ClientProfileNavigationBottomSheet>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {

        return when (className) {
//            ClientProfileNavigationBottomSheet::class.java.name -> profileNavigationBottomSheet.get()
            else -> super.instantiate(classLoader, className)
        }
    }
}
