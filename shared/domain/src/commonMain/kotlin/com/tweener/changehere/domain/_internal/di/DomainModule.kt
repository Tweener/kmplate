package com.tweener.changehere.domain._internal.di

import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val domainModule = module {

    includes(useCaseModule)

}
