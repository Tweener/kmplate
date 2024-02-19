package com.tweener.changehere.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.tweener.changehere.presentation._internal.navigation.MyProjectNavigationBar
import com.tweener.changehere.presentation._internal.navigation.tab.FavoritesTab
import com.tweener.changehere.presentation._internal.navigation.tab.HomeTab
import com.tweener.changehere.presentation._internal.navigation.tab.ProfileTab
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

class MainScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: MainViewModel = koinInject()

        TabNavigator(
            tab = HomeTab,
            key = "tabNavigator",
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = listOf(HomeTab, FavoritesTab, ProfileTab)
                )
            }
        ) {
            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                bottomBar = { MyProjectNavigationBar() }
            ) { innerPadding ->
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        .consumeWindowInsets(innerPadding)
                        .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)),
                ) {
                    CurrentTab()
                }
            }
        }
    }
}
