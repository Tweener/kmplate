package com.tweener.changehere.domain._internal.di

import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val domainModule by DI.Module(name = "Domain Layer Module") {

    importOnce(useCaseModule)

}
