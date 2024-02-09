package com.tweener.changehere.domain.repository

/**
 * @author Vivien Mahe
 * @since 18/10/2023
 */
interface SettingsRepository {

    sealed class InputParams {
        data class SetDarkMode(val isDarkModeEnabled: Boolean) : InputParams()
    }

    sealed class OutputParams {
        data class GetDarkMode(val isDarkModeEnabled: Boolean) : OutputParams()
    }

    suspend fun setDarkMode(inputParams: InputParams.SetDarkMode)

    suspend fun getDarkMode(): OutputParams.GetDarkMode
}
