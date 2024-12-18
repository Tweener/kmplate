package com.tweener.changehere.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.tweener.changehere.presentation._internal.dispatcher.ToastMessageDispatcher
import com.tweener.changehere.presentation._internal.navigation.bar.MyProjectNavigationBar
import com.tweener.changehere.presentation._internal.navigation.tab.HomeTab
import com.tweener.czan._internal.kotlinextensions.subscribe
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

class MainScreen : Screen {

    @Composable
    override fun Content() {
        val viewModel: MainViewModel = koinInject()
        val navigationItems by viewModel.navigationItems.collectAsStateWithLifecycle()
        val toastMessageDispatcher: ToastMessageDispatcher = koinInject()
        val snackbarScope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        toastMessageDispatcher.toastMessage.subscribe { snackbarScope.launch { snackbarHostState.showSnackbar(message = it) } }

        TabNavigator(
            tab = HomeTab,
            key = "tabNavigator",
            tabDisposable = {
                TabDisposable(
                    navigator = it,
                    tabs = navigationItems
                )
            }
        ) {
            Scaffold(
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                navigationBar = { MyProjectNavigationBar(navigationItems = navigationItems) }
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

        LaunchedEffect(Unit) {
            viewModel.initViewModel()
        }
    }
}
