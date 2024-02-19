package com.tweener.changehere.presentation._internal.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tweener.changehere.presentation.screen.home.navigation.HomeTab
import com.tweener.changehere.presentation.theme.MyProjectUIDefaults

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun MyProjectBottomNavigation(
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier
            .background(MyProjectUIDefaults.Navigation.containerColor())
            .windowInsetsPadding(WindowInsets.navigationBars),
        elevation = 0.dp,
    ) {
        TabNavigationItem(tab = HomeTab)
    }
}
