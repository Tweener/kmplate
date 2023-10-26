package com.tweener.changehere.domain.usecase

import kotlinx.coroutines.flow.Flow

/**
 * Base class for any use case that emits once or more.
 *
 * @author Vivien Mahe
 * @since 15/04/2023
 */
abstract class StreamUseCase<InputParams, OutputParams> : BaseUseCase<InputParams, OutputParams, Flow<OutputParams>>()
