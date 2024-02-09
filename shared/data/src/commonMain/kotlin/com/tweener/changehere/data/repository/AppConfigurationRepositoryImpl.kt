package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.local.datasource.LocalAppConfigurationDataSource
import com.tweener.changehere.domain.entity.AppConfiguration
import com.tweener.changehere.domain.repository.AppConfigurationRepository
import com.tweener.firebase.remoteconfig.datasource.RemoteConfigDataSource

/**
 * @author Vivien Mahe
 * @since 29/12/2023
 */
class AppConfigurationRepositoryImpl(
    private val localAppConfigurationDataSource: LocalAppConfigurationDataSource,
    private val remoteConfigDataSource: RemoteConfigDataSource,
) : AppConfigurationRepository {

    override suspend fun getAppConfiguration(): AppConfigurationRepository.OutputParams.GetAppConfiguration {
        if (localAppConfigurationDataSource.appConfiguration == null) {
            // val someRemoteConfigProperty = remoteConfigDataSource.getLong(key = RemoteConfigModel(key = RemoteConfigKey.SOME_REMOTE_CONFIG_PROPERTY).key.value, defaultValue = 3)

            localAppConfigurationDataSource.appConfiguration = AppConfiguration(
                id = "" // TODO Add proper mapping for app configuration properties
                // someRemoteConfigProperty = someRemoteConfigProperty.toInt(),
            )
        }

        return AppConfigurationRepository.OutputParams.GetAppConfiguration(appConfiguration = localAppConfigurationDataSource.appConfiguration!!)
    }
}
