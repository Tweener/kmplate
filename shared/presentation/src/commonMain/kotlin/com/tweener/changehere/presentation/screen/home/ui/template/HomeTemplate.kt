package com.tweener.changehere.presentation.screen.home.ui.template

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.text.Text
import com.tweener.czan.theme.Size
import kmplate.shared.presentation.generated.resources.Res
import kmplate.shared.presentation.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeTemplate(
    modifier: Modifier = Modifier,
    onClick: (() -> Unit)? = null,
) {
    var showContent by remember { mutableStateOf(false) }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .windowInsetsPadding(WindowInsets.statusBars),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                text = "Click me!",
                onClick = { showContent = !showContent }
            )

            AnimatedVisibility(showContent) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painter = painterResource(resource = Res.drawable.compose_multiplatform), contentDescription = null)
                    Text(text = "Compose: Hellow")
                }
            }

            Spacer(modifier = Modifier.padding(vertical = Size.Padding.Default))

            Button(
                text = "Open new screen",
                onClick = { onClick?.invoke() }
            )
        }
    }
}
