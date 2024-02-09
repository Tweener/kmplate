package com.tweener.changehere.android._internal.di.module.data

import com.tweener.common._internal.LocaleProvider
import com.tweener.common._internal.createLocaleProvider
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val dataModule by DI.Module(name = "Data Layer Module") {

    bindSingleton<LocaleProvider> { createLocaleProvider() }

    importOnce(mapperModule)
    importOnce(dataSourceModule)
    importOnce(repositoryModule)

}
