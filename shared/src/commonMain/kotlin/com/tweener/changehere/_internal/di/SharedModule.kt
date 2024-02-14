package com.tweener.changehere._internal.di

import com.tweener.changehere.Test
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import com.tweener.changehere._internal.os.thread.CoroutinesThreadDispatcher
import com.tweener.changehere.data._internal.di.dataModule
import com.tweener.changehere.domain._internal.di.domainModule
import com.tweener.changehere.presentation._internal.di.presentationModule
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

fun sharedDI() = DI {
    import(sharedModule())
}

fun sharedModule() = DI.Module("Shared module") {

    bindSingleton { Test(name = "OUI OUI") }

    bindSingleton { CoroutinesThreadDispatcher() }
    bindSingleton { CoilConfiguration() }

    importOnce(dataModule)
    importOnce(domainModule)
    importOnce(presentationModule)

}
