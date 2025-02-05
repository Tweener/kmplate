package com.tweener.changehere.data._internal.libs.room

import androidx.room.Room
import androidx.room.RoomDatabase
import com.tweener.changehere.data.source.room.MyProjectRoomDatabase
import kotlinx.cinterop.ExperimentalForeignApi
import platform.Foundation.NSDocumentDirectory
import platform.Foundation.NSFileManager
import platform.Foundation.NSUserDomainMask

/**
 * @author Vivien Mahe
 * @since 09/01/2025
 */
@OptIn(ExperimentalForeignApi::class)
class RoomIosDatabaseHelper : RoomDatabaseHelper() {

    override fun createDatabaseBuilder(): RoomDatabase.Builder<MyProjectRoomDatabase> =
        Room.databaseBuilder<MyProjectRoomDatabase>(name = documentDirectory() + "/" + getDatabaseFilename())

    override fun deleteDatabase() {
        NSFileManager.defaultManager.removeItemAtPath(path = documentDirectory() + getDatabaseFilename(), error = null)
    }

    private fun documentDirectory(): String {
        val documentDirectory = NSFileManager.defaultManager.URLForDirectory(
            directory = NSDocumentDirectory,
            inDomain = NSUserDomainMask,
            appropriateForURL = null,
            create = false,
            error = null,
        )
        return requireNotNull(documentDirectory?.path)
    }
}
