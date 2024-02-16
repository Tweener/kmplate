package com.tweener.changehere._internal.di

import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 16/02/2024
 */

val sharedIosModule = module {

    includes(sharedModule)

    // Add here specific dependencies for iOS
}
