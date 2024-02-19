package com.tweener.changehere.presentation.screen.favorites.di

import com.tweener.changehere._internal.di.viewModelDefinition
import com.tweener.changehere.presentation.screen.favorites.FavoritesViewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val favoritesModule = module {

    viewModelDefinition {
        FavoritesViewModel()
    }
}
