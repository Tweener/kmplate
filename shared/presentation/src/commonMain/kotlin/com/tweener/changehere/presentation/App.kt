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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import com.tweener.changehere.presentation._internal.dispatcher.ToastMessageDispatcher
import com.tweener.changehere.presentation._internal.libs.coil.CoilConfiguration
import com.tweener.changehere.presentation.screen.MainScreen
import com.tweener.changehere.presentation.theme.MyProjectTheme
import com.tweener.czan._internal.kotlinextensions.subscribe
import com.tweener.czan.designsystem.atom.scaffold.Scaffold
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun App() {
    KoinContext {
        val coilConfiguration: CoilConfiguration = koinInject()
        val toastMessageDispatcher: ToastMessageDispatcher = koinInject()
        val snackbarScope = rememberCoroutineScope()
        val snackbarHostState = remember { SnackbarHostState() }

        coilConfiguration.init()
        toastMessageDispatcher.toastMessage.subscribe { snackbarScope.launch { snackbarHostState.showSnackbar(message = it) } }

        MyProjectTheme {
            Navigator(
                screen = MainScreen(),
                key = "rootNavigator",
            ) {
                Scaffold(
                    contentWindowInsets = WindowInsets(0, 0, 0, 0),
                    containerColor = MaterialTheme.colorScheme.surface,
                    snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding)
                            .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal)),
                    ) {
                        CurrentScreen()
                    }
                }
            }
        }
    }
}
