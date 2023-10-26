package com.tweener.changehere.data.source.local.datasource

import platform.Foundation.NSUserDefaults

/**
 * @author Vivien Mahe
 * @since 05/10/2023
 */

actual class LocalStorageDataSource {

    actual fun getString(key: String, defaultValue: String?): String? =
        NSUserDefaults.standardUserDefaults.stringForKey(key) ?: defaultValue

    actual fun setString(key: String, value: String) {
        NSUserDefaults.standardUserDefaults.setObject(value, key)
    }

    actual fun getBoolean(key: String): Boolean =
        NSUserDefaults.standardUserDefaults.boolForKey(key)

    actual fun setBoolean(key: String, value: Boolean) {
        NSUserDefaults.standardUserDefaults.setBool(value, key)
    }

    actual fun getInt(key: String, defaultValue: Int): Int =
        NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()

    actual fun setInt(key: String, value: Int) {
        NSUserDefaults.standardUserDefaults.setInteger(value.toLong(), key)
    }
}
