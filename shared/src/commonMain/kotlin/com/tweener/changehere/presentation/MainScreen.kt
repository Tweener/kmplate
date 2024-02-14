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
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import com.tweener.changehere.presentation.screen.home.ui.template.HomeTemplate
import com.tweener.changehere.presentation.theme.MyProjectTheme
import org.kodein.di.compose.rememberInstance

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

@Composable
fun MainScreen() {
    val viewModel: MainViewModel by rememberInstance()
    val coilConfiguration: CoilConfiguration by rememberInstance()

    coilConfiguration.init()

    MyProjectTheme {
        Scaffold(
            contentWindowInsets = WindowInsets(0, 0, 0, 0),
            bottomBar = {
//                if (appState.shouldShowBottomBar) {
//                    QuotellBottomBar(appState = appState)
//                }
            }
        ) { innerPadding ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .consumeWindowInsets(innerPadding)
                    .windowInsetsPadding(
                        WindowInsets.safeDrawing.only(
                            WindowInsetsSides.Horizontal,
                        ),
                    ),
            ) {
                HomeTemplate()
            }
        }
    }
}
