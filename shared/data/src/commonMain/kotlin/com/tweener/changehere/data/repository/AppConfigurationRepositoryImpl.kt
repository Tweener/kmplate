package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.firebase.remoteconfig.model.RemoteConfigKey
import com.tweener.changehere.data.source.firebase.remoteconfig.model.RemoteConfigModel
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
            val appRatingAskPeriodMonths = remoteConfigDataSource.getLong(key = RemoteConfigModel(key = RemoteConfigKey.APP_RATING_ASK_PERIOD_MONTHS).key.value, defaultValue = 3)

            localAppConfigurationDataSource.appConfiguration = AppConfiguration(
                appRatingAskPeriodMonths = appRatingAskPeriodMonths.toInt(),
                // TODO Add proper mapping for app configuration properties
            )
        }

        return AppConfigurationRepository.OutputParams.GetAppConfiguration(appConfiguration = localAppConfigurationDataSource.appConfiguration!!)
    }
}
