package com.tweener.changehere._internal.di

import org.koin.core.context.startKoin

/**
 * @author Vivien Mahe
 * @since 16/02/2024
 */

fun initKoin() {
    startKoin {
        modules(sharedIosModule)
    }
}
