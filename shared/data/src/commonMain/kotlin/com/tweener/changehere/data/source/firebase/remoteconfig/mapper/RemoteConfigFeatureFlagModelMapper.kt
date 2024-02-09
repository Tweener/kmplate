package com.tweener.changehere.data.source.firebase.remoteconfig.mapper

import com.tweener.changehere.data.source.firebase.remoteconfig.model.RemoteConfigKey
import com.tweener.changehere.data.source.firebase.remoteconfig.model.RemoteConfigModel
import com.tweener.changehere.domain.entity.FeatureFlag
import com.tweener.changehere.domain.mapper.EntityToModelMapper

/**
 * @author Vivien Mahe
 * @since 16/12/2023
 */
class RemoteConfigFeatureFlagModelMapper : EntityToModelMapper<FeatureFlag, RemoteConfigModel> {

    override fun convertToModel(entity: FeatureFlag): RemoteConfigModel {
        val key = when (entity) {
            // TODO Add here mapping for feature flags, ie:
            FeatureFlag.AI_GENERATION_ENABLED -> RemoteConfigKey.AI_GENERATION_ENABLED
        }

        return RemoteConfigModel(key = key)
    }
}
