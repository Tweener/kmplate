package com.tweener.changehere.data.source.local.datasource

import com.russhwolf.settings.ExperimentalSettingsApi
import com.russhwolf.settings.coroutines.FlowSettings
import kotlinx.coroutines.flow.Flow

/**
 * @author Vivien Mahe
 * @since 05/10/2023
 */
@OptIn(ExperimentalSettingsApi::class)
class LocalStorageDataSource(
    private val settings: FlowSettings,
) {
    suspend fun getString(key: String): String? =
        settings.getStringOrNull(key)

    fun getStringAsFlow(key: String, defaultValue: String): Flow<String> =
        settings.getStringFlow(key, defaultValue)

    suspend fun setString(key: String, value: String) {
        settings.putString(key, value)
    }

    suspend fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        settings.getBoolean(key, defaultValue)

    fun getBooleanAsFlow(key: String, defaultValue: Boolean): Flow<Boolean> =
        settings.getBooleanFlow(key, defaultValue)

    suspend fun setBoolean(key: String, value: Boolean) {
        settings.putBoolean(key, value)
    }

    suspend fun getInt(key: String, defaultValue: Int): Int =
        settings.getInt(key, defaultValue)

    fun getIntAsFlow(key: String, defaultValue: Int): Flow<Int> =
        settings.getIntFlow(key, defaultValue)

    suspend fun setInt(key: String, value: Int) {
        settings.putInt(key, value)
    }
}
