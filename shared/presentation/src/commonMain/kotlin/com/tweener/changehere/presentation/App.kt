package com.tweener.changehere.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.tweener.changehere.presentation._internal.libs.coil.CoilConfiguration
import com.tweener.changehere.presentation.screen.MainScreen
import com.tweener.changehere.presentation.theme.MyProjectTheme
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

        coilConfiguration.init()

        MyProjectTheme {
            Navigator(
                screen = MainScreen(),
                key = "rootNavigator",
            )
        }
    }
}
