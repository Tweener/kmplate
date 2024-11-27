package com.tweener.changehere.presentation.screen.home.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tweener.changehere.presentation._internal.kotlinextensions.findRootNavigator
import com.tweener.changehere.presentation.screen.detail.ui.screen.DetailScreen
import com.tweener.changehere.presentation.screen.home.HomeViewModel
import com.tweener.changehere.presentation.screen.home.ui.template.HomeTemplate
import com.tweener.czan._internal.kotlinextensions.subscribe
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinInject()
    val navigator = LocalNavigator.currentOrThrow.findRootNavigator()

    viewModel.openDetailScreen.subscribe { id -> navigator.push(item = DetailScreen(id = id)) }

    HomeTemplate(
        onClick = { viewModel.onDetailButtonClicked() },
    )
}
