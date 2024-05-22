package com.tweener.changehere._internal.libs.firebase

import dev.gitlive.firebase.Firebase
import dev.gitlive.firebase.initialize

/**
 * @author Vivien Mahe
 * @since 22/05/2024
 */

actual fun initializeFirebase() {
    Firebase.initialize()
}
