package com.tweener.changehere.presentation.screen.detail.ui.screen

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import com.dokar.sonner.Toaster
import com.dokar.sonner.rememberToasterState
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
        val toaster = rememberToasterState()

        viewModel.toastMessage.subscribe { toaster.show(message = it) }

        DetailTemplate(
            onClick = { viewModel.onShowToastButtonClicked() },
        )

        Toaster(
            state = toaster,
            darkTheme = isSystemInDarkTheme(),
            maxVisibleToasts = 1,
        )

        viewModel.initViewModel(id = id)
    }
}
