package com.tweener.changehere.android._internal.di.module.data

import com.tweener.changehere.data.source.firebase.remoteconfig.mapper.RemoteConfigFeatureFlagModelMapper
import org.kodein.di.DI
import org.kodein.di.bindProvider

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val mapperModule = DI.Module(name = "Mappers") {

    // Remote Config
    bindProvider { RemoteConfigFeatureFlagModelMapper() }
}
