package net.adamhilton.kotlinkats

import android.app.Application
import net.adamhilton.kotlinkats.injection.component.AppComponent
import net.adamhilton.kotlinkats.injection.component.DaggerAppComponent
import net.adamhilton.kotlinkats.injection.module.AppModule
import timber.log.Timber



class KotlinKatsApp : Application() {

    companion object {
        @JvmStatic lateinit private var Instance: KotlinKatsApp
        @JvmStatic lateinit private var AppComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        Instance = this
        AppComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}