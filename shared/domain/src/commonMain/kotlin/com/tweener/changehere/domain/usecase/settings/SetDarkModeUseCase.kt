package com.tweener.changehere.domain.usecase.settings

import com.tweener.changehere.domain.repository.SettingsRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 18/10/2023
 */
class SetDarkModeUseCase(
    private val settingsRepository: SettingsRepository
) : CompletableUseCase<SetDarkModeUseCase.InputParams>() {

    class InputParams(
        val isDarkModeEnabled: Boolean
    )

    override suspend fun buildUseCase(params: InputParams?) {
        assertInputParamsNotNull(params)

        settingsRepository.setDarkMode(SettingsRepository.InputParams.SetDarkMode(isDarkModeEnabled = params.isDarkModeEnabled))
    }
}
