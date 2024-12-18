package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.SingleUseCase
import com.tweener.changehere.domain.usecase.config.GetAppRatingAskPeriodMonthsUseCase
import com.tweener.kmpkit.kotlinextensions.now
import kotlinx.datetime.LocalDate
import kotlinx.datetime.minus

/**
 * We ask the user for app review every 2 months.
 *
 * @author Vivien Mahe
 * @since 10/01/2024
 */
class ShouldAskForAppReviewUseCase(
    private val userRepository: UserRepository,
    private val getAppRatingAskPeriodMonthsUseCase: GetAppRatingAskPeriodMonthsUseCase,
) : SingleUseCase<Nothing, ShouldAskForAppReviewUseCase.OutputParams>() {

    class OutputParams(
        val shouldAsk: Boolean
    )

    override suspend fun buildUseCase(params: Nothing?): OutputParams {
        val getLastAskForAppReviewDate = userRepository.getLastAskForAppReviewDate().date
        val appRatingAskPeriodMonths = getAppRatingAskPeriodMonthsUseCase.execute().periodMonths

        val shouldAsk = when (getLastAskForAppReviewDate) {
            null -> {
                // Never asked the user yet
                true
            }

            else -> {
                // Already asked the user previously
                val periodSinceLastAsked = getLastAskForAppReviewDate.date.minus(LocalDate.now())
                periodSinceLastAsked.months >= appRatingAskPeriodMonths
            }
        }

        return OutputParams(shouldAsk = shouldAsk)
    }
}
