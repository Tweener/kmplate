package com.tweener.changehere.presentation._internal.navigation

import cafe.adriel.voyager.navigator.Navigator

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

fun Navigator.findRootNavigator(): Navigator =
    parent?.findRootNavigator() ?: this
