package com.tweener.changehere.android._internal.di.module.domain

import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val domainModule by DI.Module(name = "Domain Layer Module") {

    importOnce(useCaseModule)

}
