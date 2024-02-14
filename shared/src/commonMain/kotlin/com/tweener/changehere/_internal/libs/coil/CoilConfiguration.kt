package com.tweener.changehere._internal.libs.coil

import androidx.compose.runtime.Composable
import coil3.ImageLoader
import coil3.annotation.ExperimentalCoilApi
import coil3.compose.setSingletonImageLoaderFactory
import coil3.fetch.NetworkFetcher
import coil3.util.DebugLogger

/**
 * @author Vivien Mahe
 * @since 04/02/2024
 */
class CoilConfiguration {

    @OptIn(ExperimentalCoilApi::class)
    @Composable
    fun init() {
        setSingletonImageLoaderFactory { context ->
            ImageLoader.Builder(context)
                .components {
                    add(NetworkFetcher.Factory())
                }
                .logger(DebugLogger())
                .apply { configureBuilder(builder = this) }
                .build()
        }
    }
}

expect fun configureBuilder(builder: ImageLoader.Builder): ImageLoader.Builder
