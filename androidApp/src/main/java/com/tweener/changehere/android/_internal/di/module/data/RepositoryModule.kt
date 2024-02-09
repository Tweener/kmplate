package com.tweener.changehere.android._internal.di.module.data

import com.tweener.changehere.data.repository.AppConfigurationRepositoryImpl
import com.tweener.changehere.data.repository.PlatformRepositoryImpl
import com.tweener.changehere.domain.repository.AppConfigurationRepository
import com.tweener.changehere.domain.repository.PlatformRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val repositoryModule by DI.Module(name = "Repositories") {

    bindProvider<PlatformRepository> { PlatformRepositoryImpl() }

    bindProvider<AppConfigurationRepository> { AppConfigurationRepositoryImpl(localAppConfigurationDataSource = instance(), remoteConfigDataSource = instance()) }

}
