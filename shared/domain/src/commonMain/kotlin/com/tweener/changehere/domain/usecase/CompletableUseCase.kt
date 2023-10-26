package com.tweener.changehere.domain.usecase

/**
 * Base class for any use case that will be executed without emitting any value.
 *
 * @author Vivien Mahe
 * @since 15/04/2023
 */
abstract class CompletableUseCase<InputParams> : BaseUseCase<InputParams, Nothing, Unit>()
