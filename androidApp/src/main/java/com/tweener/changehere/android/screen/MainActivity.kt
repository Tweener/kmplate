package com.tweener.changehere.android.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.tweener.changehere.presentation.MainScreen
import com.tweener.changehere.android.screen._di.mainModule
import org.kodein.di.Copy
import org.kodein.di.DIAware
import org.kodein.di.android.closestDI
import org.kodein.di.android.retainedSubDI

class MainActivity : ComponentActivity(), DIAware {

    override val di by retainedSubDI(closestDI(), copy = Copy.All) { import(mainModule) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}
