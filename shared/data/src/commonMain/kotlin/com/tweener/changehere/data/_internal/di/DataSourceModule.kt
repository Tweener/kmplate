package com.tweener.changehere.data._internal.di

import com.tweener.changehere.data.source.firebase.firestore.datasource.FirestoreUsersDataSource
import com.tweener.changehere.data.source.local.datasource.LocalAppConfigurationDataSource
import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
import com.tweener.firebase.firestore.FirestoreService
import com.tweener.firebase.functions.FirebaseFunctionsService
import com.tweener.firebase.remoteconfig.RemoteConfigService
import com.tweener.firebase.remoteconfig.datasource.RemoteConfigDataSource
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

fun dataSourceModule(isDebug: Boolean) = module {

    // Local
    factory { LocalStorageDataSource(settings = get()) }
    single { LocalAppConfigurationDataSource() }

    // Firestore
    single { FirestoreService() }
    single { FirestoreUsersDataSource(firestoreService = get()) }

    // Remote Config
    single { RemoteConfigService(isDebug = isDebug) }
    single { RemoteConfigDataSource(firebaseRemoteConfigService = get()) }

    // Firebase Functions
    single { FirebaseFunctionsService() }
}
