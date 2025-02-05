package com.tweener.changehere.data._internal.libs.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tweener.changehere.data.source.room.MyProjectRoomDatabase

/**
 * @author Vivien Mahe
 * @since 09/01/2025
 */
class RoomAndroidDatabaseHelper(private val context: Context) : RoomDatabaseHelper() {

    override fun createDatabaseBuilder(): RoomDatabase.Builder<MyProjectRoomDatabase> =
        Room.databaseBuilder<MyProjectRoomDatabase>(context = context, name = context.getDatabasePath(getDatabaseFilename()).absolutePath)


    override fun deleteDatabase() {
        context.deleteDatabase(getDatabaseFilename())
    }
}
