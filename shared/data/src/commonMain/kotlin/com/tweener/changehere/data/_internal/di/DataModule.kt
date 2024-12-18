package com.tweener.changehere.data._internal.di

import com.tweener.kmpkit.provider.LocaleProvider
import com.tweener.kmpkit.provider.createLocaleProvider
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */
fun dataModule(isDebug: Boolean) = module {

    single<LocaleProvider> { createLocaleProvider() }

    includes(mapperModule)
    includes(dataSourceModule(isDebug = isDebug))
    includes(repositoryModule)

}
