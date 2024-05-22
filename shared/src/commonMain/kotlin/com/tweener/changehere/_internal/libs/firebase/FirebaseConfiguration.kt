package com.tweener.changehere._internal.libs.firebase

/**
 * @author Vivien Mahe
 * @since 22/05/2024
 */
class FirebaseConfiguration {

    fun init() {
        initializeFirebase()
    }
}

expect fun initializeFirebase()
