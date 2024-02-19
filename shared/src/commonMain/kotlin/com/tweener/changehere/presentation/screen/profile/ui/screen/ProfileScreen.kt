package com.tweener.changehere.presentation.screen.profile.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.tweener.changehere.presentation.screen.favorites.FavoritesViewModel
import com.tweener.changehere.presentation.screen.favorites.ui.template.FavoritesTemplate
import com.tweener.changehere.presentation.screen.profile.ui.template.ProfileTemplate
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

class ProfileScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: FavoritesViewModel = koinInject()

        ProfileTemplate()
    }
}
