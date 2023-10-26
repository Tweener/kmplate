package com.tweener.changehere.domain.mapper

/**
 * @author Vivien Mahe
 * @since 22/08/2023
 */
interface EntityToModelMapper<Entity, Model> {

    /**
     * Converts the given [Entity] to a [Model].
     */
    fun convertToModel(entity: Entity): Model
}
