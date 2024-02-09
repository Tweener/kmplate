package com.tweener.changehere.domain.repository

import com.tweener.changehere.domain.entity.FeatureFlag

/**
 * @author Vivien Mahe
 * @since 16/12/2023
 */
interface FeatureFlagRepository {

    sealed class InputParams {
        data class Get(val featureFlag: FeatureFlag) : InputParams()
    }

    sealed class OutputParams {
        data class Get(val enabled: Boolean) : OutputParams()
    }

    suspend fun get(inputParams: InputParams.Get): OutputParams.Get
}
