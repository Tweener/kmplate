package com.tweener.changehere.presentation._internal.navigation

import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.tweener.changehere.presentation._internal.navigation.tab.FavoritesTab
import com.tweener.changehere.presentation._internal.navigation.tab.HomeTab
import com.tweener.changehere.presentation._internal.navigation.tab.ProfileTab

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun MyProjectNavigationBar(
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier
    ) {
        TabNavigationItem(tab = HomeTab)
        TabNavigationItem(tab = FavoritesTab)
        TabNavigationItem(tab = ProfileTab)
    }
}
