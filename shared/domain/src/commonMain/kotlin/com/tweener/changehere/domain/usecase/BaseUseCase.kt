package com.tweener.changehere.domain.usecase

import com.tweener.changehere.domain.error.MissingUseCaseInputParamsException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * @author Vivien Mahe
 * @since 22/08/2023
 */
abstract class BaseUseCase<InputParams, OutputParams, T> {

    protected abstract suspend fun buildUseCase(inputParams: InputParams?): T

    suspend fun execute(inputParams: InputParams? = null): T = buildUseCase(inputParams)

    /**
     * Asserts the given [inputParams] are not null or throws a [MissingUseCaseInputParamsException].
     *
     * @param inputParams The params given as input of this use-case.
     * @throws MissingUseCaseInputParamsException
     */
    @OptIn(ExperimentalContracts::class)
    fun assertInputParamsNotNull(inputParams: InputParams? = null): InputParams {
        contract {
            returns() implies (inputParams != null)
        }

        if (inputParams == null) {
            throw MissingUseCaseInputParamsException(this)
        }

        return inputParams
    }
}
