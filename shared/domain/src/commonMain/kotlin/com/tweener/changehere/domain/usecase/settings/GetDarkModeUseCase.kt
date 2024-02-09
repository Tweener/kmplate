package com.tweener.changehere.domain.usecase.settings

import com.tweener.changehere.domain.repository.SettingsRepository
import com.tweener.changehere.domain.usecase.SingleUseCase

/**
 * @author Vivien Mahe
 * @since 18/10/2023
 */
class GetDarkModeUseCase(
    private val settingsRepository: SettingsRepository
) : SingleUseCase<Nothing, GetDarkModeUseCase.OutputParams>() {

    class OutputParams(
        val isDarkModeEnabled: Boolean
    )

    override suspend fun buildUseCase(params: Nothing?): OutputParams =
        OutputParams(isDarkModeEnabled = settingsRepository.getDarkMode().isDarkModeEnabled)
}
