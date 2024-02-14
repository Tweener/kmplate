package com.tweener.changehere._internal.di

import com.tweener.changehere.Test
import com.tweener.changehere._internal.libs.LibrariesConfiguration
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import com.tweener.changehere._internal.libs.napier.CrashlyticsAntilog
import com.tweener.changehere._internal.libs.napier.NapierConfiguration
import com.tweener.changehere._internal.os.thread.CoroutinesThreadDispatcher
import com.tweener.changehere.data._internal.di.dataModule
import com.tweener.changehere.domain._internal.di.domainModule
import com.tweener.changehere.presentation._internal.di.presentationModule
import com.tweener.firebase.crashlytics.CrashlyticsService
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

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

    // Coil
    bindSingleton { CoilConfiguration() }

    // Firebase Crashlytics
    bindSingleton { CrashlyticsService() }

    // Napier
    bindSingleton { CrashlyticsAntilog(crashlyticsService = instance()) }
    bindSingleton { NapierConfiguration(crashlyticsAntilog = instance()) }

    // Libraries
    bindSingleton { LibrariesConfiguration(napierConfiguration = instance()) }

    importOnce(dataModule)
    importOnce(domainModule)
    importOnce(presentationModule)

}
