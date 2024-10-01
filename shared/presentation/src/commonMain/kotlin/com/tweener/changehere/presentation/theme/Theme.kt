package com.tweener.changehere.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.tweener.czan.theme.CzanTheme

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun MyProjectTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    CzanTheme(
        darkTheme = darkTheme,
        lightColorScheme = LightColorScheme,
        darkColorScheme = DarkColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
