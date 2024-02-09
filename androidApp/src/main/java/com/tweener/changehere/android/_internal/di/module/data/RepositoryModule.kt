package com.tweener.changehere.android._internal.di.module.data

import com.tweener.changehere.data.repository.AppConfigurationRepositoryImpl
import com.tweener.changehere.data.repository.FeatureFlagRepositoryImpl
import com.tweener.changehere.data.repository.PlatformRepositoryImpl
import com.tweener.changehere.data.repository.SettingsRepositoryImpl
import com.tweener.changehere.data.repository.UserRepositoryImpl
import com.tweener.changehere.domain.repository.AppConfigurationRepository
import com.tweener.changehere.domain.repository.FeatureFlagRepository
import com.tweener.changehere.domain.repository.PlatformRepository
import com.tweener.changehere.domain.repository.SettingsRepository
import com.tweener.changehere.domain.repository.UserRepository
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val repositoryModule by DI.Module(name = "Repositories") {

    bindProvider<PlatformRepository> { PlatformRepositoryImpl() }

    bindProvider<SettingsRepository> { SettingsRepositoryImpl(localStorageDataSource = instance()) }
    bindProvider<AppConfigurationRepository> { AppConfigurationRepositoryImpl(localAppConfigurationDataSource = instance(), remoteConfigDataSource = instance()) }
    bindProvider<FeatureFlagRepository> { FeatureFlagRepositoryImpl(remoteConfigFeatureFlagModelMapper = instance(), remoteConfigDataSource = instance()) }
    bindProvider<UserRepository> { UserRepositoryImpl(localStorageDataSource = instance(), firebaseAuthDataSource = instance(), firestoreUsersDataSource = instance()) }

}
