package com.tweener.changehere.presentation.profile.ui.template

import androidx.compose.runtime.Composable
import com.tweener.changehere.presentation.screen.profile.ui.template.ProfileTemplate
import com.tweener.changehere.presentation.theme.MyProjectTheme
import com.tweener.czan.preview.UiModePreviews

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */


@UiModePreviews
@Composable
private fun ProfileTemplatePreview() {
    MyProjectTheme {
        ProfileTemplate()
    }
}
