package com.tweener.changehere.data.source.local.datasource

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

/**
 * @author Vivien Mahe
 * @since 05/10/2023
 */

const val LOCAL_STORAGE_SHARED_PREF_NAME = "localStorage"

actual class LocalStorageDataSource(
    val context: Context
) {
    actual fun getString(key: String, defaultValue: String?): String? {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        return prefs.getString(key, defaultValue)
    }

    actual fun setString(key: String, value: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(key, value)
        editor.apply()
    }

    actual fun getBoolean(key: String): Boolean {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        return prefs.getBoolean(key, false)
    }

    actual fun setBoolean(key: String, value: Boolean) {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    actual fun getInt(key: String, defaultValue: Int): Int {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        return prefs.getInt(key, defaultValue)
    }

    actual fun setInt(key: String, value: Int) {
        val prefs: SharedPreferences = context.getSharedPreferences(LOCAL_STORAGE_SHARED_PREF_NAME, MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt(key, value)
        editor.apply()
    }
}
