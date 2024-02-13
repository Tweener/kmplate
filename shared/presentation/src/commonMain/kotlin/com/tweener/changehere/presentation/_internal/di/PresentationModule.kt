package com.tweener.changehere.presentation._internal.di

import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */

val presentationModule by DI.Module("Presentation layer module") {

    importOnce(uiMapperModule)

}
