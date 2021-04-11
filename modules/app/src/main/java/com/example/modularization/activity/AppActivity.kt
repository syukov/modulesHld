package com.example.modularization.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.modularization.app.R
import com.example.modularization.app.TheApp
import javax.inject.Inject

class AppActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: AppActivityFragmentFactory

    companion object {
        private const val ROOT_FRAGMENT_TAG = "ROOT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        TheApp.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        supportFragmentManager.fragmentFactory = fragmentFactory
        setContentView(R.layout.activity_app)

        if (supportFragmentManager.findFragmentByTag(ROOT_FRAGMENT_TAG) == null) {
            val rootFragment = fragmentFactory.instantiate(this.classLoader, "")
            supportFragmentManager.beginTransaction()
                .replace(R.id.app_container, rootFragment, ROOT_FRAGMENT_TAG)
                .commit()
        }
    }
}