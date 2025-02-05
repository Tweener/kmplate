package com.tweener.changehere.data.source.room.datasource

import com.tweener.changehere.data.source.room.dao.RoomExampleDao
import com.tweener.changehere.data.source.room.model.RoomExampleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author Vivien Mahe
 * @since 08/01/2025
 */
class RoomExampleDataSource(
    private val roomExampleDao: RoomExampleDao,
) {

    suspend fun get(): RoomExampleModel? =
        roomExampleDao
            .getAll()
            .firstOrNull()

    fun getAsFlow(): Flow<RoomExampleModel?> =
        roomExampleDao
            .getAllAsFlow()
            .map { it.firstOrNull() }

    suspend fun save(model: RoomExampleModel): RoomExampleModel =
        roomExampleDao.save(model = model)

    suspend fun create(amount: Double, currency: String, createdAt: Long): RoomExampleModel =
        roomExampleDao.create(amount = amount, currency = currency, createdAt = createdAt)
}
