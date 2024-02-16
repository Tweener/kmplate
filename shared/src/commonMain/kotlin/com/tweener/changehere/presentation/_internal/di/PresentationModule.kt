package com.tweener.changehere.presentation._internal.di

import com.tweener.changehere._internal.di.viewModelDefinition
import com.tweener.changehere.presentation.MainViewModel
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val presentationModule = module {

    includes(uiMapperModule)

    viewModelDefinition {
        MainViewModel(
            loadAppConfigUseCase = get(),
        )
    }

}
