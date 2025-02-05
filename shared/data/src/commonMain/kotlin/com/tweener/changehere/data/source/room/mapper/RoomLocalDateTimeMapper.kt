package com.tweener.changehere.data.source.room.mapper

import com.tweener.changehere.domain.mapper.EntityMapper
import com.tweener.kmpkit.kotlinextensions.fromEpochMilliseconds
import com.tweener.kmpkit.kotlinextensions.toEpochMilliseconds
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone

/**
 * @author Vivien Mahe
 * @since 06/01/2025
 */
class RoomLocalDateTimeMapper(
    private val timeZone: TimeZone,
) : EntityMapper<LocalDateTime, Long> {

    override fun convertToModel(entity: LocalDateTime): Long =
        entity.toEpochMilliseconds(timeZone = timeZone)

    override fun convertToEntity(model: Long): LocalDateTime =
        model.fromEpochMilliseconds(timeZone = timeZone)
}
