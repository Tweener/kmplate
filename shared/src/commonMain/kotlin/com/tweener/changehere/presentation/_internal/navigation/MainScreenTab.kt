package com.tweener.changehere.presentation._internal.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import kmplate.shared.generated.resources.Res
import kmplate.shared.generated.resources.navigation_tab_favorites
import kmplate.shared.generated.resources.navigation_tab_home
import kmplate.shared.generated.resources.navigation_tab_profile
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.StringResource

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@OptIn(ExperimentalResourceApi::class)
enum class MainScreenTab(
    val index: UShort,
    val title: StringResource,
    val icon: ImageVector,
) {
    HOME(
        index = 0u,
        title = Res.string.navigation_tab_home,
        icon = Icons.Default.Home,
    ),

    FAVORITES(
        index = 1u,
        title = Res.string.navigation_tab_favorites,
        icon = Icons.Default.Favorite,
    ),

    PROFILE(
        index = 2u,
        title = Res.string.navigation_tab_profile,
        icon = Icons.Default.Person,
    );

    companion object {
        fun getDefault(): MainScreenTab = HOME
    }
}
