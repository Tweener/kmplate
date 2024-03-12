package com.tweener.changehere.presentation.favorites.ui.template

import androidx.compose.runtime.Composable
import com.tweener.changehere.presentation.screen.favorites.ui.template.FavoritesTemplate
import com.tweener.changehere.presentation.theme.MyProjectTheme
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */


@UiModePreviews
@Composable
private fun FavoritesTemplatePreview() {
    MyProjectTheme {
        FavoritesTemplate()
    }
}
