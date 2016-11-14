package net.adamhilton.kotlinkats

import android.app.Application
import com.squareup.picasso.Picasso
import net.adamhilton.kotlinkats.injection.component.AppComponent
import net.adamhilton.kotlinkats.injection.component.DaggerAppComponent
import net.adamhilton.kotlinkats.injection.module.AppModule
import timber.log.Timber

class KotlinKatsApp : Application() {

    companion object {
        @JvmStatic lateinit var Instance: KotlinKatsApp
        @JvmStatic lateinit var AppComponent: AppComponent
        @JvmStatic lateinit var Picasso: Picasso
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this
        AppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        Picasso = AppComponent.picasso()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}