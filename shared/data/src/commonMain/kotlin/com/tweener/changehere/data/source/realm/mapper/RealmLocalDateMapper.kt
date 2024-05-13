package com.tweener.changehere.data.source.realm.mapper

import com.tweener.changehere.domain.mapper.EntityMapper
import com.tweener.realm.toInstant
import com.tweener.realm.toRealmInstant
import io.realm.kotlin.types.RealmInstant
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.atTime
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

/**
 * @author Vivien Mahe
 * @since 08/05/2024
 */
class RealmLocalDateMapper : EntityMapper<LocalDate, RealmInstant> {

    override fun convertToModel(entity: LocalDate): RealmInstant =
        entity
            .atTime(hour = 0, minute = 0, second = 0)
            .toInstant(TimeZone.currentSystemDefault())
            .toRealmInstant()

    override fun convertToEntity(model: RealmInstant): LocalDate =
        model
            .toInstant()
            .toLocalDateTime(TimeZone.currentSystemDefault())
            .date
}
