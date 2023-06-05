package com.tweener.changehere.android._internal.di.module

import com.tweener.changehere.data.PlatformRepositoryImpl
import com.tweener.changehere.domain.PlatformRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val repositoryModule by DI.Module(name = "Repositories") {

    bindProvider<PlatformRepository> { PlatformRepositoryImpl() }

}
