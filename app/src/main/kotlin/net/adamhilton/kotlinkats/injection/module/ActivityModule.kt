package net.adamhilton.kotlinkats.injection.module

import android.content.Context
import android.support.v7.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import net.adamhilton.kotlinkats.injection.qualifier.ActivityContext
import net.adamhilton.kotlinkats.injection.scope.PerActivity


@Module
class ActivityModule(private val activity: AppCompatActivity) {

    @Provides
    @PerActivity
    @ActivityContext
    internal fun provideActivityContext(): Context {
        return activity
    }

}