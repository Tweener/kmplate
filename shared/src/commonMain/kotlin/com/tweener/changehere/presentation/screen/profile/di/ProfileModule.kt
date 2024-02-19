package com.tweener.changehere.presentation.screen.profile.di

import com.tweener.changehere._internal.di.viewModelDefinition
import com.tweener.changehere.presentation.screen.profile.ProfileViewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */

val profileModule = module {

    viewModelDefinition {
        ProfileViewModel()
    }
}
