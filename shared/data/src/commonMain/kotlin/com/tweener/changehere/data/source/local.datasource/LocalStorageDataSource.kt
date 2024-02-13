package com.tweener.changehere.data.source.local.datasource

import com.tweener.common._internal.KMPContext

/**
 * @author Vivien Mahe
 * @since 05/10/2023
 */
expect class LocalStorageDataSource(context: KMPContext) {
    fun getString(key: String, defaultValue: String?): String?
    fun setString(key: String, value: String)

    fun getBoolean(key: String): Boolean
    fun setBoolean(key: String, value: Boolean)

    fun getInt(key: String, defaultValue: Int): Int
    fun setInt(key: String, value: Int)
}

interface Test {
    fun getString(key: String, defaultValue: String?): String?
}
