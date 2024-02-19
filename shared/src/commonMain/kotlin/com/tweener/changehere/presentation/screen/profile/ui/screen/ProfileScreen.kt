package com.tweener.changehere.presentation.screen.profile.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tweener.changehere.presentation._internal.navigation.findRootNavigator
import com.tweener.changehere.presentation.screen.favorites.FavoritesViewModel
import com.tweener.changehere.presentation.screen.profile.ui.template.ProfileTemplate
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun ProfileScreen() {
    val viewModel: FavoritesViewModel = koinInject()
    val navigator = LocalNavigator.currentOrThrow.findRootNavigator()

    ProfileTemplate()
}
