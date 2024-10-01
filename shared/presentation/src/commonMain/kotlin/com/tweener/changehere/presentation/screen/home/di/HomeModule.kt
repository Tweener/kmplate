package com.tweener.changehere.presentation.screen.home.di

import com.tweener.changehere.presentation._internal.kotlinextensions.viewModelDefinition
import com.tweener.changehere.presentation.screen.home.HomeViewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val homeModule = module {

    viewModelDefinition {
        HomeViewModel()
    }
}
