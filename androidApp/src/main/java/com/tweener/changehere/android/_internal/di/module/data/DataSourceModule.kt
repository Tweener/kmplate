package com.tweener.changehere.android._internal.di.module.data

import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
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

}
