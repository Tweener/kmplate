package com.tweener.changehere.domain.usecase

/**
 * Base class for any use case that will emit only once.
 *
 * @author Vivien Mahe
 * @since 15/04/2023
 */
abstract class SingleUseCase<InputParams, OutputParams> : BaseUseCase<InputParams, OutputParams, OutputParams>()
