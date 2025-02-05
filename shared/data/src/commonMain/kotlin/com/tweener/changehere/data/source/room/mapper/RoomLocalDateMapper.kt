package com.tweener.changehere.data.source.room.mapper

import com.tweener.changehere.domain.mapper.EntityMapper
import com.tweener.kmpkit.kotlinextensions.fromEpochMilliseconds
import com.tweener.kmpkit.kotlinextensions.toEpochMilliseconds
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime

/**
 * @author Vivien Mahe
 * @since 06/01/2025
 */
class RoomLocalDateMapper(
    private val timeZone: TimeZone,
) : EntityMapper<LocalDate, Long> {

    override fun convertToModel(entity: LocalDate): Long =
        entity.atTime(hour = 0, minute = 0, second = 0).toEpochMilliseconds(timeZone = timeZone)

    override fun convertToEntity(model: Long): LocalDate =
        model.fromEpochMilliseconds(timeZone = timeZone).date
}
