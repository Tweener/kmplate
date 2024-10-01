package com.tweener.changehere.presentation.screen.detail.di

import com.tweener.changehere.presentation._internal.kotlinextensions.viewModelDefinition
import com.tweener.changehere.presentation.screen.detail.DetailViewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val detailModule = module {

    viewModelDefinition {
        DetailViewModel()
    }
}
