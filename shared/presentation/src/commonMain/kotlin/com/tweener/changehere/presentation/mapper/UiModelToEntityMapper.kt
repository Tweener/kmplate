package com.tweener.changehere.presentation.mapper

/**
 * @author Vivien Mahe
 * @since 05/11/2023
 */
interface UiModelToEntityMapper<UiModel, Entity> {

    /**
     * Converts the given [UiModel] to an [Entity].
     */
    fun convertToEntity(model: UiModel): Entity
}
