package com.tweener.changehere.data.source.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.tweener.changehere.data.source.room.model.RoomExampleModel
import kotlinx.coroutines.flow.Flow
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * @author Vivien Mahe
 * @since 08/01/2025
 */
@Dao
interface RoomExampleDao {

    @Query("SELECT * FROM RoomExampleModel")
    suspend fun getAll(): List<RoomExampleModel>

    @Query("SELECT * FROM RoomExampleModel")
    fun getAllAsFlow(): Flow<List<RoomExampleModel>>

    @Query("SELECT * FROM RoomExampleModel WHERE id = :id")
    suspend fun getById(id: String): RoomExampleModel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(model: RoomExampleModel)

    @Transaction
    suspend fun save(model: RoomExampleModel): RoomExampleModel {
        // Check if the model exists
        val existingModel = getById(id = model.id)

        // If the model exists and is identical, return it
        if (existingModel == model) {
            return existingModel
        }

        // If different or does not exist, upsert and return the new model
        upsert(model)
        return model
    }

    @OptIn(ExperimentalUuidApi::class)
    suspend fun create(amount: Double, currency: String, createdAt: Long): RoomExampleModel {
        val model = RoomExampleModel(
            id = Uuid.random().toString(),
            amount = amount,
            currency = currency,
            createdAt = createdAt,
        )

        upsert(model)

        return model
    }

    @Query("DELETE FROM RoomExampleModel WHERE id = :id")
    suspend fun deleteById(id: String)

    @Query("DELETE FROM RoomExampleModel")
    suspend fun clear()

}
