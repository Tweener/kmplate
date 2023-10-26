package com.tweener.changehere.domain.mapper

/**
 * @author Vivien Mahe
 * @since 22/08/2023
 */
interface EntityMapper<Entity, Model> : EntityToModelMapper<Entity, Model>, ModelToEntityMapper<Model, Entity>
