package com.tweener.changehere.android

import android.app.Application
import com.tweener.changehere._internal.di.sharedAndroidDI
import com.tweener.changehere._internal.libs.LibrariesConfiguration
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
class MyApplication : Application(), DIAware {

    private val librariesConfiguration: LibrariesConfiguration by instance()

    override val di: DI = sharedAndroidDI(context = this@MyApplication)

    override fun onCreate() {
        super.onCreate()

        librariesConfiguration.init()
    }
}
