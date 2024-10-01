package com.tweener.changehere.android

import android.app.Application
import com.tweener.changehere._internal.di.sharedAndroidModule
import com.tweener.changehere.presentation._internal.libs.LibrariesConfiguration
import org.koin.android.ext.android.inject
import org.koin.core.context.startKoin

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
class MyApplication : Application() {

    private val librariesConfiguration: LibrariesConfiguration by inject()

    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(sharedAndroidModule(context = this@MyApplication))
        }

        librariesConfiguration.init()
    }
}
