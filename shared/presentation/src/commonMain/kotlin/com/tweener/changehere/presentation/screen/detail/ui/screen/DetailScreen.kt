package com.tweener.changehere.presentation.screen.detail.ui.screen

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tweener.changehere.presentation._internal.kotlinextensions.findRootNavigator
import com.tweener.changehere.presentation.screen.detail.DetailViewModel
import com.tweener.changehere.presentation.screen.detail.ui.template.DetailTemplate
import com.tweener.czan._internal.kotlinextensions.subscribe
import org.koin.compose.koinInject

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */
class DetailScreen(val id: String) : Screen {

    @Composable
    override fun Content() {
        val viewModel: DetailViewModel = koinInject()
        val navigator = LocalNavigator.currentOrThrow.findRootNavigator()

        viewModel.closeScreen.subscribe { navigator.pop() }

        DetailTemplate(
            onBackClicked = { viewModel.onBackClicked() },
            onClick = { viewModel.onShowToastButtonClicked() },
        )

        viewModel.initViewModel(id = id)
    }
}
