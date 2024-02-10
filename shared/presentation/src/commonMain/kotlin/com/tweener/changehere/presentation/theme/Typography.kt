package com.tweener.changehere.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import kmplate.shared.presentation.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.Font

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

// region FontFamily

@OptIn(ExperimentalResourceApi::class)
val LatoFont: FontFamily
    @Composable get() = FontFamily(
        Font(resource = Res.font.lato_regular),
        Font(resource = Res.font.lato_italic, style = FontStyle.Italic),
        Font(resource = Res.font.lato_bold, weight = FontWeight.Medium),
        Font(resource = Res.font.lato_bold_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
        Font(resource = Res.font.lato_black, weight = FontWeight.Bold),
        Font(resource = Res.font.lato_black_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
    )

// endregion FontFamily

// region Typography

val MyProjectTypography: Typography
    @Composable get() = Typography(
        labelLarge = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            fontSize = 12.sp
        ),
        labelMedium = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 16.sp,
            fontSize = 10.sp
        ),
        labelSmall = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 16.sp,
            fontSize = 8.sp
        ),
        bodyLarge = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 22.sp,
            fontSize = 16.sp
        ),
        bodyMedium = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            fontSize = 14.sp
        ),
        bodySmall = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 16.sp,
            fontSize = 12.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 48.sp,
            fontSize = 32.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.sp,
            lineHeight = 36.sp,
            fontSize = 28.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 32.sp,
            fontSize = 24.sp
        ),
        displayLarge = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 64.sp,
            fontSize = 57.sp
        ),
        displayMedium = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 52.sp,
            fontSize = 45.sp
        ),
        displaySmall = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 44.sp,
            fontSize = 36.sp
        ),
        titleLarge = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Normal,
            letterSpacing = 0.sp,
            lineHeight = 28.sp,
            fontSize = 22.sp
        ),
        titleMedium = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Bold,
            letterSpacing = 0.sp,
            lineHeight = 24.sp,
            fontSize = 18.sp
        ),
        titleSmall = TextStyle(
            fontFamily = LatoFont,
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.sp,
            lineHeight = 20.sp,
            fontSize = 16.sp
        )
    )

// endregion Typography
