package com.tweener.changehere._internal.di

import com.tweener.changehere.BuildKonfig
import com.tweener.changehere._internal.libs.LibrariesConfiguration
import com.tweener.changehere.data._internal.di.dataModule
import com.tweener.changehere.data._internal.libs.room.RoomConfiguration
import com.tweener.changehere.domain._internal.di.domainModule
import com.tweener.changehere.presentation._internal.di.presentationModule
import com.tweener.changehere.presentation._internal.dispatcher.ToastMessageDispatcher
import com.tweener.changehere.presentation._internal.libs.coil.CoilConfiguration
import com.tweener.changehere.presentation._internal.libs.firebase.FirebaseConfiguration
import com.tweener.changehere.presentation._internal.libs.napier.CrashlyticsAntilog
import com.tweener.changehere.presentation._internal.libs.napier.NapierConfiguration
import com.tweener.changehere.presentation._internal.os.thread.CoroutinesThreadDispatcher
import com.tweener.firebase.crashlytics.CrashlyticsService
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val sharedModule = module {

    single { CoroutinesThreadDispatcher() }
    single { ToastMessageDispatcher(toastMessageMapper = get()) }

    // Coil
    single { CoilConfiguration() }

    // Firebase
    single { FirebaseConfiguration() }
    single { CrashlyticsService() }

    // Napier
    single { CrashlyticsAntilog(crashlyticsService = get()) }
    single { NapierConfiguration(isDebug = BuildKonfig.DEBUG, crashlyticsAntilog = get(), crashlyticsService = get()) }

    // Room
    single { RoomConfiguration(databaseHelper = get()) }

    // Libraries
    single { LibrariesConfiguration(napierConfiguration = get(), firebaseConfiguration = get(), roomConfiguration = get()) }

    includes(dataModule(isDebug = BuildKonfig.DEBUG))
    includes(domainModule)
    includes(presentationModule)

}
