package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.firebase.remoteconfig.mapper.RemoteConfigFeatureFlagModelMapper
import com.tweener.changehere.domain.repository.FeatureFlagRepository
import com.tweener.firebase.remoteconfig.datasource.RemoteConfigDataSource

/**
 * @author Vivien Mahe
 * @since 16/12/2023
 */
class FeatureFlagRepositoryImpl(
    private val remoteConfigFeatureFlagModelMapper: RemoteConfigFeatureFlagModelMapper,
    private val remoteConfigDataSource: RemoteConfigDataSource,
) : FeatureFlagRepository {

    override suspend fun get(inputParams: FeatureFlagRepository.InputParams.Get): FeatureFlagRepository.OutputParams.Get =
        remoteConfigDataSource
            .getBoolean(key = remoteConfigFeatureFlagModelMapper.convertToModel(inputParams.featureFlag).key.value, defaultValue = inputParams.featureFlag.defaultValue)
            .let { FeatureFlagRepository.OutputParams.Get(enabled = it) }
}
