package com.tweener.changehere.data.source.realm.mapper

import com.tweener.changehere.domain.mapper.EntityMapper
import com.tweener.realm.toInstant
import com.tweener.realm.toRealmInstant
import io.realm.kotlin.types.RealmInstant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime

/**
 * @author Vivien Mahe
 * @since 08/05/2024
 */
class RealmLocalDateTimeMapper : EntityMapper<LocalDateTime, RealmInstant> {

    override fun convertToModel(entity: LocalDateTime): RealmInstant =
        entity.toInstant(TimeZone.currentSystemDefault()).toRealmInstant()

    override fun convertToEntity(model: RealmInstant): LocalDateTime =
        model.toInstant().toLocalDateTime(TimeZone.currentSystemDefault())
}
