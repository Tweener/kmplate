package com.tweener.changehere.domain.usecase.config

import com.tweener.changehere.domain.repository.AppConfigurationRepository
import com.tweener.changehere.domain.usecase.SingleUseCase

/**
 * @author Vivien Mahe
 * @since 29/12/2023
 */
class GetAppRatingAskPeriodMonthsUseCase(
    private val appConfigurationRepository: AppConfigurationRepository
) : SingleUseCase<Nothing, GetAppRatingAskPeriodMonthsUseCase.OutputParams>() {

    class OutputParams(
        val periodMonths: Int
    )

    override suspend fun buildUseCase(params: Nothing?): OutputParams =
        OutputParams(periodMonths = appConfigurationRepository.getAppConfiguration().appConfiguration.appRatingAskPeriodMonths)
}
