package com.tweener.changehere.data.source.room

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor
import com.tweener.changehere.data.source.room.dao.RoomExampleDao
import com.tweener.changehere.data.source.room.model.RoomExampleModel

/**
 * @author Vivien Mahe
 * @since 05/02/2025
 */
@Database(
    entities = [
        RoomExampleModel::class,
        // TODO Add here all other models
    ],
    version = 1,
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class MyProjectRoomDatabase : RoomDatabase() {

    abstract fun getExampleDao(): RoomExampleDao

    // TODO Add here all other DAOs

}

@Suppress("NO_ACTUAL_FOR_EXPECT")
expect object AppDatabaseConstructor : RoomDatabaseConstructor<MyProjectRoomDatabase> {
    override fun initialize(): MyProjectRoomDatabase
}
