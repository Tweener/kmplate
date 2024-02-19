package com.tweener.changehere.presentation.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */
object MyProjectUIDefaults {

    object Navigation {
        @Composable
        fun containerColor() = MaterialTheme.colorScheme.surfaceVariant

        @Composable
        fun contentColor() = MaterialTheme.colorScheme.onSurfaceVariant

        @Composable
        fun selectedIconColor() = MaterialTheme.colorScheme.onSecondaryContainer

        @Composable
        fun selectedTextColor() = MaterialTheme.colorScheme.onSurface

        @Composable
        fun indicatorColor() = MaterialTheme.colorScheme.secondaryContainer
    }
}
