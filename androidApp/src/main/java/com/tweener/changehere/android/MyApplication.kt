package com.tweener.changehere.android

import android.app.Application
import com.tweener.changehere._internal.di.sharedAndroidDI
import com.tweener.changehere._internal.os.thread.CoroutinesThreadDispatcher
import com.tweener.changehere._internal.libs.napier.NapierConfiguration
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
class MyApplication : Application(), DIAware {

    private val threadsDispatcher: CoroutinesThreadDispatcher by instance()
    private val napierConfiguration: NapierConfiguration by instance()

    override val di: DI = sharedAndroidDI(context = this@MyApplication)
//    override val di by DI.lazy {
//        import(rootModule(context = this@MyApplication))
//    }

    override fun onCreate() {
        super.onCreate()

        napierConfiguration.init()
    }
}
