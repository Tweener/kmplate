package com.tweener.changehere.data.source.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Vivien Mahe
 * @since 05/02/2025
 */
@Entity
data class RoomExampleModel(
    @PrimaryKey val id: String,
    val amount: Double,
    val currency: String,
    val createdAt: Long,
    val updatedAt: Long? = null,
    val deletedAt: Long? = null
)
