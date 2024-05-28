package com.tweener.changehere.domain.usecase.featureflag

import com.tweener.changehere.domain.entity.FeatureFlag
import com.tweener.changehere.domain.repository.FeatureFlagRepository
import com.tweener.changehere.domain.usecase.SingleUseCase

/**
 * @author Vivien Mahe
 * @since 16/12/2023
 */
class GetFeatureFlagUseCase(
    private val featureFlagRepository: FeatureFlagRepository,
) : SingleUseCase<GetFeatureFlagUseCase.InputParams, GetFeatureFlagUseCase.OutputParams>() {

    class InputParams(
        val featureFlag: FeatureFlag
    )

    class OutputParams(
        val enabled: Boolean
    )

    override suspend fun buildUseCase(inputParams: InputParams?): OutputParams {
        val params = assertInputParamsNotNull(inputParams)

        return featureFlagRepository
            .get(FeatureFlagRepository.InputParams.Get(featureFlag = params.featureFlag))
            .let { OutputParams(enabled = it.enabled) }
    }
}
