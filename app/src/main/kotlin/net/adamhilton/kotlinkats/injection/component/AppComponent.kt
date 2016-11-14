package net.adamhilton.kotlinkats.injection.component

import android.content.Context
import dagger.Component
import net.adamhilton.kotlinkats.injection.module.AppModule
import net.adamhilton.kotlinkats.injection.qualifier.AppContext
import net.adamhilton.kotlinkats.injection.scope.PerApplication

@PerApplication
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    @AppContext
    fun context() : Context
}
