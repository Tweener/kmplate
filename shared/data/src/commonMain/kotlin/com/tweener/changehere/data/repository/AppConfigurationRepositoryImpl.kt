package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.local.datasource.LocalAppConfigurationDataSource
import com.tweener.changehere.domain.entity.AppConfiguration
import com.tweener.changehere.domain.repository.AppConfigurationRepository

/**
 * @author Vivien Mahe
 * @since 29/12/2023
 */
class AppConfigurationRepositoryImpl(
    private val localAppConfigurationDataSource: LocalAppConfigurationDataSource,
) : AppConfigurationRepository {

    override suspend fun getAppConfiguration(): AppConfigurationRepository.OutputParams.GetAppConfiguration {
        if (localAppConfigurationDataSource.appConfiguration == null) {
            localAppConfigurationDataSource.appConfiguration = AppConfiguration(
                id = "" // TODO Add proper mapping for app configuration properties
            )
        }

        return AppConfigurationRepository.OutputParams.GetAppConfiguration(appConfiguration = localAppConfigurationDataSource.appConfiguration!!)
    }
}
