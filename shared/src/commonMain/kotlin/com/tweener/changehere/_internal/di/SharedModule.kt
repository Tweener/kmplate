package com.tweener.changehere._internal.di

import com.tweener.changehere._internal.libs.LibrariesConfiguration
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import com.tweener.changehere._internal.libs.napier.CrashlyticsAntilog
import com.tweener.changehere._internal.libs.napier.NapierConfiguration
import com.tweener.changehere._internal.os.thread.CoroutinesThreadDispatcher
import com.tweener.changehere.data._internal.di.dataModule
import com.tweener.changehere.domain._internal.di.domainModule
import com.tweener.changehere.presentation._internal.di.presentationModule
import com.tweener.firebase.crashlytics.CrashlyticsService
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val sharedModule = module {

    single { CoroutinesThreadDispatcher() }

    // Coil
    single { CoilConfiguration() }

    // Firebase Crashlytics
    single { CrashlyticsService() }

    // Napier
    single { CrashlyticsAntilog(crashlyticsService = get()) }
    single { NapierConfiguration(crashlyticsAntilog = get()) }

    // Libraries
    single { LibrariesConfiguration(napierConfiguration = get()) }

    includes(dataModule)
    includes(domainModule)
    includes(presentationModule)

}
