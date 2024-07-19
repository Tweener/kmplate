package com.tweener.changehere.presentation._internal.kotlinextensions

import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

fun Navigator.findRootNavigator(): Navigator =
    parent?.findRootNavigator() ?: this

fun Navigator.open(item: Screen, closeCurrentScreen: Boolean = false, closeAllPreviousScreens: Boolean = false) {
    with(item) {
        when {
            closeAllPreviousScreens -> this@open.replaceAll(item = this@with)
            closeCurrentScreen -> this@open.replace(this@with)
            else -> this@open.push(this@with)
        }
    }
}
