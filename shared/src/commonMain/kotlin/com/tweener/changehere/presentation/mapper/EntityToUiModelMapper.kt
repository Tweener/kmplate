package com.tweener.changehere.presentation.mapper

/**
 * @author Vivien Mahe
 * @since 05/11/2023
 */
interface EntityToUiModelMapper<Entity, UiModel> {

    /**
     * Converts the given [Entity] to a [UiModel].
     */
    fun convertToUiModel(entity: Entity): UiModel
}
