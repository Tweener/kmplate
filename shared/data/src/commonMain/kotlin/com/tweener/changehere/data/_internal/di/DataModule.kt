package com.tweener.changehere.data._internal.di

import com.tweener.common._internal.LocaleProvider
import com.tweener.common._internal.createLocaleProvider
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */
val dataModule = module {

    single<LocaleProvider> { createLocaleProvider() }

    includes(mapperModule)
    includes(dataSourceModule)
    includes(repositoryModule)

}
