package com.tweener.changehere.presentation.screen

import androidx.compose.runtime.Composable
import com.tweener.changehere.presentation._internal.libs.coil.CoilConfiguration
import org.kodein.di.compose.rememberInstance

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

@Composable
fun MainScreen() {
    val viewModel: MainViewModel by rememberInstance()
    val coilConfiguration: CoilConfiguration by rememberInstance()

}
