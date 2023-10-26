package com.tweener.changehere.domain.mapper

/**
 * @author Vivien Mahe
 * @since 22/08/2023
 */
interface ModelToEntityMapper<Model, Entity> {

    /**
     * Converts the given [Model] to an [Entity].
     */
    fun convertToEntity(model: Model): Entity
}
