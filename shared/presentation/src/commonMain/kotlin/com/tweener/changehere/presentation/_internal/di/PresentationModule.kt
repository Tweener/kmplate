package com.tweener.changehere.presentation._internal.di

import com.tweener.changehere.presentation.screen.MainViewModel
import com.tweener.changehere.presentation.screen.detail.di.detailModule
import com.tweener.changehere.presentation.screen.favorites.di.favoritesModule
import com.tweener.changehere.presentation.screen.home.di.homeModule
import com.tweener.changehere.presentation.screen.profile.di.profileModule
import org.koin.dsl.module
import org.koin.core.module.dsl.viewModel

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val presentationModule = module {

    includes(uiMapperModule)

    viewModel {
        MainViewModel(
            loadAppConfigUseCase = get(),
        )
    }

    // Screens
    includes(homeModule)
    includes(favoritesModule)
    includes(profileModule)
    includes(detailModule)
}
