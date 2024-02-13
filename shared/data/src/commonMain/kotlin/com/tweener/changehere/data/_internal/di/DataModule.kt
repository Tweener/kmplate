package com.tweener.changehere.data._internal.di

import com.tweener.common._internal.LocaleProvider
import com.tweener.common._internal.createLocaleProvider
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */
val dataModule by DI.Module(name = "Data Layer Module") {

    bindSingleton<LocaleProvider> { createLocaleProvider() }

    importOnce(mapperModule)
    importOnce(dataSourceModule)
    importOnce(repositoryModule)

}
