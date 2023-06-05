package com.tweener.changehere.android._internal.di.module

import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val dataModule by DI.Module(name = "Data Layer Module") {

    import(repositoryModule)

}
