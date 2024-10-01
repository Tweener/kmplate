package com.tweener.changehere.presentation.screen.detail.ui.template

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.changehere.presentation.screen.detail.ui.atom.DetailTopBar
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.theme.Size

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

@Composable
fun DetailTemplate(
    modifier: Modifier = Modifier,
    onBackClicked: (() -> Unit)? = null,
    onClick: (() -> Unit)? = null,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DetailTopBar(onBackClicked = { onBackClicked?.invoke() })

            Spacer(modifier = Modifier.padding(vertical = Size.Padding.Default))

            Button(
                text = "Show toast",
                onClick = { onClick?.invoke() }
            )
        }
    }
}
