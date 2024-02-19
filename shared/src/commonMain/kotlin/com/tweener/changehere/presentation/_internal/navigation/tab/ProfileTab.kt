package com.tweener.changehere.presentation._internal.navigation.tab

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabOptions
import com.tweener.changehere.presentation.screen.profile.ui.screen.ProfileScreen
import kmplate.shared.generated.resources.Res
import kmplate.shared.generated.resources.navigation_tab_profile
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.stringResource

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

object ProfileTab : Tab {

    @OptIn(ExperimentalResourceApi::class)
    override val options: TabOptions
        @Composable
        get() {
            val title = stringResource(resource = Res.string.navigation_tab_profile)
            val icon = rememberVectorPainter(Icons.Default.Person)

            return remember {
                TabOptions(
                    index = 2u,
                    title = title,
                    icon = icon,
                )
            }
        }

    @Composable
    override fun Content() {
        Navigator(screen = ProfileScreen())
    }
}
