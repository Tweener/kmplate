package com.tweener.changehere.android._internal.di.module.data

import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val dataModule by DI.Module(name = "Data Layer Module") {

    importOnce(mapperModule)
    importOnce(dataSourceModule)
    importOnce(repositoryModule)

}
