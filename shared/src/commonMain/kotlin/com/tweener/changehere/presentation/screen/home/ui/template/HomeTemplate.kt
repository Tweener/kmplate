package com.tweener.changehere.presentation.screen.home.ui.template

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.czan.designsystem.atom.button.Button
import com.tweener.czan.designsystem.atom.text.Text
import kmplate.shared.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun HomeTemplate(
    modifier: Modifier = Modifier
) {
    var showContent by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize(),
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
    }
}
