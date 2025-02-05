package com.tweener.changehere.data._internal.di

import com.tweener.changehere.data.source.firebase.remoteconfig.mapper.RemoteConfigFeatureFlagModelMapper
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val mapperModule = module {

    // Remote Config
    factory { RemoteConfigFeatureFlagModelMapper() }

}
