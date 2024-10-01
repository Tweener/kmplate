package com.tweener.changehere.presentation._internal.navigation.tab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tweener.changehere.presentation._internal.navigation.MainScreenTab
import com.tweener.changehere.presentation.screen.favorites.ui.screen.FavoritesScreen
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

object FavoritesTab : Tab {

    private val mainScreenTab = MainScreenTab.FAVORITES

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(resource = mainScreenTab.title)
            val icon = rememberVectorPainter(mainScreenTab.icon)

            return remember {
                TabOptions(
                    index = mainScreenTab.index,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        FavoritesScreen()
    }
}
