package com.tweener.changehere.data._internal.libs.room

import com.tweener.changehere.data.source.room.MyProjectRoomDatabase
import io.github.aakira.napier.Napier

/**
 * @author Vivien Mahe
 * @since 07/01/2025
 */
class RoomConfiguration(
    private val databaseHelper: RoomDatabaseHelper,
) {

    private lateinit var database: MyProjectRoomDatabase

    fun init() {
        database = databaseHelper.createDatabase()
        Napier.d { "Room database initialized." }
    }

    fun getDatabase(): MyProjectRoomDatabase = database
}
