package com.tweener.changehere.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

/**
 * @author Vivien Mahe
 * @since 23/08/2023
 */

@Composable
fun colorResource(colorLight: Color, colorDark: Color = Color.Unspecified) =
    if (isSystemInDarkTheme()) colorDark else colorLight

// Common colors
val shadow: Color
    @Composable get() = colorResource(colorLight = md_theme_light_shadow, colorDark = md_theme_dark_shadow)

val gray: Color
    @Composable get() = colorResource(colorLight = Color(0xFFA2A3AD), colorDark = Color(0xFF7C7C83))

val softGreen: Color
    @Composable get() = colorResource(colorLight = light_softGreen, colorDark = dark_softGreen)

val onSoftGreen: Color
    @Composable get() = colorResource(colorLight = light_onSoftGreen, colorDark = dark_onSoftGreen)

val softGreenContainer: Color
    @Composable get() = colorResource(colorLight = light_softGreenContainer, colorDark = dark_softGreenContainer)

val onSoftGreenContainer: Color
    @Composable get() = colorResource(colorLight = light_onSoftGreenContainer, colorDark = dark_onSoftGreenContainer)

// Light colors
val md_theme_light_primary = Color(0xFF006399)
val md_theme_light_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_primaryContainer = Color(0xFFCDE5FF)
val md_theme_light_onPrimaryContainer = Color(0xFF001D32)
val md_theme_light_secondary = Color(0xFF825500)
val md_theme_light_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_secondaryContainer = Color(0xFFFFDDB3)
val md_theme_light_onSecondaryContainer = Color(0xFF291800)
val md_theme_light_tertiary = Color(0xFF6E4DA1)
val md_theme_light_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_tertiaryContainer = Color(0xFFECDCFF)
val md_theme_light_onTertiaryContainer = Color(0xFF280056)
val md_theme_light_error = Color(0xFFBA1A1A)
val md_theme_light_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_onError = Color(0xFFFFFFFF)
val md_theme_light_onErrorContainer = Color(0xFF410002)
val md_theme_light_background = Color(0xFFF5F5F5)
val md_theme_light_onBackground = Color(0xFF001D31)
val md_theme_light_surface = Color(0xFFF5F5F5)
val md_theme_light_onSurface = Color(0xFF001D31)
val md_theme_light_surfaceVariant = Color(0xFFDEE3EB)
val md_theme_light_onSurfaceVariant = Color(0xFF42474E)
val md_theme_light_outline = Color(0xFF72787F)
val md_theme_light_inverseOnSurface = Color(0xFFE7F2FF)
val md_theme_light_inverseSurface = Color(0xFF003351)
val md_theme_light_inversePrimary = Color(0xFFA9C9FF)
val md_theme_light_shadow = Color(0xFF000000)
val md_theme_light_surfaceTint = Color(0xFF006399)
val md_theme_light_outlineVariant = Color(0xFFC2C7CF)
val md_theme_light_scrim = Color(0xFF000000)

val light_softGreen = Color(0xFF246C2D)
val light_onSoftGreen = Color(0xFFFFFFFF)
val light_softGreenContainer = Color(0xFFA8F5A5)
val light_onSoftGreenContainer = Color(0xFF002105)

val MyProjectLightColorScheme = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)

// Dark colors
val md_theme_dark_primary = Color(0xFFA9C9FF)
val md_theme_dark_onPrimary = Color(0xFF003352)
val md_theme_dark_primaryContainer = Color(0xFF004A74)
val md_theme_dark_onPrimaryContainer = Color(0xFFCDE5FF)
val md_theme_dark_secondary = Color(0xFFFFB951)
val md_theme_dark_onSecondary = Color(0xFF452B00)
val md_theme_dark_secondaryContainer = Color(0xFF633F00)
val md_theme_dark_onSecondaryContainer = Color(0xFFFFDDB3)
val md_theme_dark_tertiary = Color(0xFFD6BAFF)
val md_theme_dark_onTertiary = Color(0xFF3E1C6F)
val md_theme_dark_tertiaryContainer = Color(0xFF553587)
val md_theme_dark_onTertiaryContainer = Color(0xFFECDCFF)
val md_theme_dark_error = Color(0xFFFFB4AB)
val md_theme_dark_errorContainer = Color(0xFF93000A)
val md_theme_dark_onError = Color(0xFF690005)
val md_theme_dark_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_background = Color(0xFF001D31)
val md_theme_dark_onBackground = Color(0xFFCDE5FF)
val md_theme_dark_surface = Color(0xFF001D31)
val md_theme_dark_onSurface = Color(0xFFCDE5FF)
val md_theme_dark_surfaceVariant = Color(0xFF42474E)
val md_theme_dark_onSurfaceVariant = Color(0xFFC2C7CF)
val md_theme_dark_outline = Color(0xFF8C9198)
val md_theme_dark_inverseOnSurface = Color(0xFF001D31)
val md_theme_dark_inverseSurface = Color(0xFFCDE5FF)
val md_theme_dark_inversePrimary = Color(0xFF006399)
val md_theme_dark_shadow = Color(0xFF000000)
val md_theme_dark_surfaceTint = Color(0xFFA9C9FF)
val md_theme_dark_outlineVariant = Color(0xFF42474E)
val md_theme_dark_scrim = Color(0xFF000000)

val dark_softGreen = Color(0xFF8DD88C)
val dark_onSoftGreen = Color(0xFF00390D)
val dark_softGreenContainer = Color(0xFF005317)
val dark_onSoftGreenContainer = Color(0xFFA8F5A5)

val MyProjectDarkColorScheme = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)
