package com.tweener.changehere.presentation.screen.detail.di

import com.tweener.changehere.presentation.screen.detail.DetailViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val detailModule = module {

    viewModel {
        DetailViewModel(
            toastMessageDispatcher = get(),
        )
    }
}
