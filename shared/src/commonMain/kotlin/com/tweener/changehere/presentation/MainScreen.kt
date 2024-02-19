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
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.tweener.changehere.BuildKonfig
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import com.tweener.changehere.presentation._internal.navigation.MyProjectBottomNavigation
import com.tweener.changehere.presentation.screen.home.navigation.HomeTab
import com.tweener.changehere.presentation.theme.MyProjectTheme
import io.github.aakira.napier.Napier
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

@Composable
fun MainScreen() {
    KoinContext {
        val viewModel: MainViewModel = koinInject()
        val coilConfiguration: CoilConfiguration = koinInject()

        coilConfiguration.init()

        Napier.w { "3 BuildKonfig isDebug? ${BuildKonfig.DEBUG}" }

        MyProjectTheme {
            TabNavigator(HomeTab) {
                Scaffold(
                    contentWindowInsets = WindowInsets(0, 0, 0, 0),
                    bottomBar = { MyProjectBottomNavigation() }
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
}
