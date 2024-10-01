package com.tweener.changehere.presentation._internal.navigation.bar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import com.tweener.czan.designsystem.atom.bars.NavigationBar
import com.tweener.czan.designsystem.atom.bars.NavigationBarDefaults
import com.tweener.czan.designsystem.atom.bars.NavigationBarItem
import com.tweener.czan.designsystem.atom.bars.NavigationBarItemDefaults

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun MyProjectNavigationBar(
    navigationItems: List<Tab>,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier,
        colors = NavigationBarDefaults.colors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
        ),
    ) {
        navigationItems.forEach { tab -> TabNavigationBarItem(tab = tab) }
    }
}

@Composable
private fun RowScope.TabNavigationBarItem(tab: Tab) {
    val tabNavigator = LocalTabNavigator.current

    NavigationBarItem(
        selected = tabNavigator.current == tab,
        onClick = { tabNavigator.current = tab },
        icon = tab.options.icon!!,
        label = tab.options.title.ifBlank { null },
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = MaterialTheme.colorScheme.onBackground,
            selectedTextColor = MaterialTheme.colorScheme.onBackground,
            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
            indicatorColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
    )
}
