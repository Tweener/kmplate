package com.tweener.changehere.data._internal.di

import com.tweener.changehere.data.source.firebase.remoteconfig.mapper.RemoteConfigFeatureFlagModelMapper
import com.tweener.changehere.data.source.realm.mapper.RealmLocalDateMapper
import com.tweener.changehere.data.source.realm.mapper.RealmLocalDateTimeMapper
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val mapperModule = module {

    // Remote Config
    factory { RemoteConfigFeatureFlagModelMapper() }

    // Realm
    factory { RealmLocalDateMapper() }
    factory { RealmLocalDateTimeMapper() }

}
