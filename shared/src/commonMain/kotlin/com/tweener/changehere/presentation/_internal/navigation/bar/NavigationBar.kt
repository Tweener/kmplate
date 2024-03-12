package com.tweener.changehere.presentation._internal.navigation.bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.tweener.changehere.presentation._internal.navigation.tab.FavoritesTab
import com.tweener.changehere.presentation._internal.navigation.tab.HomeTab
import com.tweener.changehere.presentation._internal.navigation.tab.ProfileTab
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun MyProjectNavigationBar(
    modifier: Modifier = Modifier,
) {
    NavigationBar(modifier = modifier) {
        TabNavigationBarItem(tab = HomeTab)
        TabNavigationBarItem(tab = FavoritesTab)
        TabNavigationBarItem(tab = ProfileTab)
    }
}

@Composable
private fun RowScope.TabNavigationBarItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current.key == tab.key,
        onClick = { tabNavigator.current = tab },
        icon = tab.options.icon,
        label = tab.options.title
    )
}
