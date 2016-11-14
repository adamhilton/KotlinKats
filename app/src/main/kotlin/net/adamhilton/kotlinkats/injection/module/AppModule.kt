package net.adamhilton.kotlinkats.injection.module

import android.app.Application
import android.content.Context
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import net.adamhilton.kotlinkats.injection.qualifier.AppContext
import net.adamhilton.kotlinkats.injection.scope.PerApplication

@Module
class AppModule(private val application: Application) {

    @Provides
    @PerApplication
    @AppContext
    internal fun provideAppContext(): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePicasso(@AppContext context: Context): Picasso {
        return Picasso.with(context)
    }

}