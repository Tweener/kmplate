package com.tweener.changehere.presentation._internal.libs.coil

import coil3.ImageLoader
import coil3.request.allowHardware

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

actual fun configureBuilder(builder: ImageLoader.Builder): ImageLoader.Builder =
    builder.allowHardware(false)
