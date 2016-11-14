package net.adamhilton.kotlinkats.injection.component

import dagger.Component
import net.adamhilton.kotlinkats.injection.scope.PerActivity
import net.adamhilton.kotlinkats.injection.module.ActivityModule
import net.adamhilton.kotlinkats.ui.main.MainActivity


@PerActivity
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(activity: MainActivity)
}