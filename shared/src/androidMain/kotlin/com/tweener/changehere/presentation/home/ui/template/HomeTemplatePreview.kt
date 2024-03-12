package com.tweener.changehere.presentation.home.ui.template

import androidx.compose.runtime.Composable
import com.tweener.changehere.presentation.screen.home.ui.template.HomeTemplate
import com.tweener.changehere.presentation.theme.MyProjectTheme
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

@UiModePreviews
@Composable
private fun HomeTemplatePreview() {
    MyProjectTheme {
        HomeTemplate()
    }
}
