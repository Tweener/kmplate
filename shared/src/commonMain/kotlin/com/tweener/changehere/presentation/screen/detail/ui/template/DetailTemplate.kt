package com.tweener.changehere.presentation.screen.detail.ui.template

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.text.Text

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun DetailTemplate(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Detail screen")

            Button(
                text = "Show toast",
                onClick = { onClick?.invoke() }
            )
        }
    }
}
