package com.tweener.changehere.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.tweener.changehere._internal.libs.coil.CoilConfiguration
import kmplate.shared.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.kodein.di.compose.rememberInstance

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MainScreen() {
    val viewModel: MainViewModel by rememberInstance()
    val coilConfiguration: CoilConfiguration by rememberInstance()

    coilConfiguration.init()

    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text(text = "Click me!")
            }
            AnimatedVisibility(showContent) {
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painter = painterResource(resource = Res.drawable.compose_multiplatform), contentDescription = null)
                    Text(text = "Compose: Hellow")
                }
            }
        }
    }
}
