package com.tweener.changehere.presentation.screen.favorites.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tweener.changehere.presentation._internal.kotlinextensions.findRootNavigator
import com.tweener.changehere.presentation.screen.favorites.FavoritesViewModel
import com.tweener.changehere.presentation.screen.favorites.ui.template.FavoritesTemplate
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun FavoritesScreen() {
    val viewModel: FavoritesViewModel = koinInject()
    val navigator = LocalNavigator.currentOrThrow.findRootNavigator()

    FavoritesTemplate()
}
