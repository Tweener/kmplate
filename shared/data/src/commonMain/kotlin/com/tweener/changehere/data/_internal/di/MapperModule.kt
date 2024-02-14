package com.tweener.changehere.data._internal.di

import com.tweener.changehere.data.source.firebase.remoteconfig.mapper.RemoteConfigFeatureFlagModelMapper
import org.kodein.di.DI
import org.kodein.di.bindProvider

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val mapperModule = DI.Module(name = "Mappers Module") {

    // Remote Config
    bindProvider { RemoteConfigFeatureFlagModelMapper() }
}
