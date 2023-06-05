package com.tweener.changehere.android.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tweener.changehere.android.MyApplicationTheme
import com.tweener.changehere.android.screen._di.mainModule
import com.tweener.changehere.data.PlatformRepositoryImpl
import com.tweener.changehere.domain.Greeting
import org.kodein.di.Copy
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.android.retainedSubDI
import org.kodein.di.compose.rememberInstance

class MainActivity : ComponentActivity(), DIAware {

    override val di by retainedSubDI(closestDI(), copy = Copy.All) { import(mainModule) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val greeting: Greeting by rememberInstance()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    GreetingView(text = greeting.greet())
                }
            }
        }
    }
}

@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
