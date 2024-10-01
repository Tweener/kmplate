package com.tweener.changehere.presentation._internal.libs

import com.tweener.changehere.presentation._internal.libs.firebase.FirebaseConfiguration
import com.tweener.changehere.presentation._internal.libs.napier.NapierConfiguration

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */
class LibrariesConfiguration(
    private val napierConfiguration: NapierConfiguration,
    private val firebaseConfiguration: FirebaseConfiguration,
) {

    fun init() {
        napierConfiguration.init()
        firebaseConfiguration.init()
    }
}
