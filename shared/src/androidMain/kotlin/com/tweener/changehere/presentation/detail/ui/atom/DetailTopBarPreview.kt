package com.tweener.changehere.presentation.detail.ui.atom

import androidx.compose.runtime.Composable
import com.tweener.changehere.presentation.screen.detail.ui.atom.DetailTopBar
import com.tweener.changehere.presentation.theme.MyProjectTheme
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 20/02/2024
 */


@UiModePreviews
@Composable
private fun DetailTopBarPreview() {
    MyProjectTheme {
        DetailTopBar(
            onBackClicked = {}
        )
    }
}
