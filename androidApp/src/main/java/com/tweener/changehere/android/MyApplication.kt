package com.tweener.changehere.android

import android.app.Application
import com.tweener.changehere.android._internal.di.module.rootModule
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import org.kodein.di.DI
import org.kodein.di.DIAware

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
class MyApplication : Application(), DIAware {

    override val di by DI.lazy {
        import(rootModule)
    }

    override fun onCreate() {
        super.onCreate()

        Napier.base(DebugAntilog())
    }
}
