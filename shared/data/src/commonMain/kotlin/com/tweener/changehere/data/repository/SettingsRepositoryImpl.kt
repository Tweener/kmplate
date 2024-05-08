package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
import com.tweener.changehere.domain.repository.SettingsRepository

/**
 * @author Vivien Mahe
 * @since 14/11/2023
 */
class SettingsRepositoryImpl(
    private val localStorageDataSource: LocalStorageDataSource,
) : SettingsRepository {

    companion object {
        private const val LOCAL_STORAGE_KEY_DARK_MODE_ENABLED = "isDarkModeEnabled"
    }

    override suspend fun setDarkMode(inputParams: SettingsRepository.InputParams.SetDarkMode) {
        localStorageDataSource.setBoolean(LOCAL_STORAGE_KEY_DARK_MODE_ENABLED, inputParams.isDarkModeEnabled)
    }

    override suspend fun getDarkMode(): SettingsRepository.OutputParams.GetDarkMode {
        val isDarkModeEnabled = localStorageDataSource.getBoolean(LOCAL_STORAGE_KEY_DARK_MODE_ENABLED, false)
        return SettingsRepository.OutputParams.GetDarkMode(isDarkModeEnabled = isDarkModeEnabled)
    }
}
