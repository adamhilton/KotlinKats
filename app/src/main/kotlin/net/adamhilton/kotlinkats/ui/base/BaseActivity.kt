package net.adamhilton.kotlinkats.ui.base

import android.support.v7.app.AppCompatActivity
import net.adamhilton.kotlinkats.KotlinKatsApp
import net.adamhilton.kotlinkats.injection.component.ActivityComponent
import net.adamhilton.kotlinkats.injection.component.DaggerActivityComponent
import net.adamhilton.kotlinkats.injection.module.ActivityModule

open class BaseActivity : AppCompatActivity() {

    private var _activityComponent: ActivityComponent? = null
    protected val ActivityComponent: ActivityComponent
    get() {
        if(_activityComponent == null) {
            _activityComponent = DaggerActivityComponent.builder()
                    .appComponent(KotlinKatsApp.AppComponent)
                    .activityModule(ActivityModule(this))
                    .build()
        }

        return _activityComponent as ActivityComponent
    }

}