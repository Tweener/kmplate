package com.tweener.changehere.presentation.screen.home.di

import com.tweener.changehere.presentation.screen.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val homeModule = module {

    viewModel {
        HomeViewModel()
    }
}
