package com.tweener.changehere.presentation._internal.di

import com.tweener.changehere.presentation.MainViewModel
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val presentationModule by DI.Module("Presentation layer module") {

    importOnce(uiMapperModule)

    bindSingleton {
        MainViewModel(
            loadAppConfigUseCase = instance(),
        )
    }

}
