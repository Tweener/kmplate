package com.tweener.changehere._internal.libs

import com.tweener.changehere._internal.libs.napier.NapierConfiguration

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */
class LibrariesConfiguration(
    private val napierConfiguration: NapierConfiguration,
) {

    fun init() {
        napierConfiguration.init()
    }
}
