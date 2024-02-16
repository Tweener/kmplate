package com.tweener.changehere.data._internal.di

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
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
val repositoryModule = module {

    factory<PlatformRepository> { PlatformRepositoryImpl() }

    factory<SettingsRepository> { SettingsRepositoryImpl(localStorageDataSource = get()) }
    factory<AppConfigurationRepository> { AppConfigurationRepositoryImpl(localAppConfigurationDataSource = get(), remoteConfigDataSource = get()) }
    factory<FeatureFlagRepository> { FeatureFlagRepositoryImpl(remoteConfigFeatureFlagModelMapper = get(), remoteConfigDataSource = get()) }
    factory<UserRepository> { UserRepositoryImpl(localStorageDataSource = get(), firebaseAuthDataSource = get(), firestoreUsersDataSource = get()) }

}
