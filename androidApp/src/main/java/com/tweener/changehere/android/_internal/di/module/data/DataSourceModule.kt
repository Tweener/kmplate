package com.tweener.changehere.android._internal.di.module.data

import com.tweener.changehere.data.source.local.datasource.LocalAppConfigurationDataSource
import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
import com.tweener.firebase.auth.FirebaseAuthService
import com.tweener.firebase.auth.datasource.FirebaseAuthDataSource
import com.tweener.firebase.firestore.FirestoreService
import com.tweener.firebase.functions.FirebaseFunctionsService
import com.tweener.firebase.remoteconfig.RemoteConfigService
import com.tweener.firebase.remoteconfig.datasource.RemoteConfigDataSource
import com.tweener.realm.RealmDatabase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val dataSourceModule by DI.Module(name = "DataSources") {

    // Realm
    bindSingleton {
        RealmDatabase(
            schema = setOf(
                // TODO Add here all RealmObjects models, ie: RealmUserModel::class,
            )
        )
    }

    // Local
    bindProvider { LocalStorageDataSource(context = instance()) }
    bindSingleton { LocalAppConfigurationDataSource() }

    // Firestore
    bindSingleton { FirestoreService() }

    // Remote Config
    bindSingleton { RemoteConfigService(isDebug = true /* BuildConfig.DEBUG */) }
    bindSingleton { RemoteConfigDataSource(firebaseRemoteConfigService = instance()) }

    // Firebase Auth
    bindSingleton { FirebaseAuthService() }
    bindSingleton { FirebaseAuthDataSource(firebaseAuthService = instance()) }

    // Firebase Functions
    bindSingleton { FirebaseFunctionsService() }
}
