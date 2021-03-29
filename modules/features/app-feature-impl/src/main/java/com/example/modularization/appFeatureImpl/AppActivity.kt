package com.example.modularization.appFeatureImpl

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.modularization.appFeatureApi.publicData.AppRouterScreen
import com.example.modularization.appFeatureApi.publicData.AppRouterScreenKey
import com.example.modularization.di.DaggerEmployeeAuthFeatureComponent
import com.example.modularization.publicContract.EmployeeAuthFeatureDeps
import javax.inject.Inject

class AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val appContainer = findViewById<FrameLayout>(R.id.app_container)
    }
}

class AppContainerFragmentFactory @Inject constructor(
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragment = super.instantiate(classLoader, className)
        return if (fragment is AppRouterScreen) {
            when (fragment.getAppRouterScreenProperties().screenKey) {
                AppRouterScreenKey.EmployeeAuth -> {
                    // create employeeAuthFeature api (component)
                    val component = DaggerEmployeeAuthFeatureComponent.factory()
                        .create(object : EmployeeAuthFeatureDeps {
                            // TODO: добавить app роутер в зависимости
                        })


                    TODO()
                }
            }
        } else {
            throw UnsupportedOperationException("fragment should implement AppRouterScreen to be opened in app container")
        }
    }
}
