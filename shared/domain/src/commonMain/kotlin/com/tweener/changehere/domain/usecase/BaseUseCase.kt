package com.tweener.changehere.domain.usecase

import com.tweener.changehere.domain.error.MissingUseCaseInputParamsException
import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract

/**
 * @author Vivien Mahe
 * @since 22/08/2023
 */
abstract class BaseUseCase<InputParams, OutputParams, T> {

    protected abstract suspend fun buildUseCase(params: InputParams?): T

    suspend fun execute(params: InputParams? = null): T = buildUseCase(params)

    /**
     * Asserts the given [params] are not null or throws a [MissingUseCaseInputParamsException].
     *
     * @param params The params given as input of this use-case.
     * @throws MissingUseCaseInputParamsException
     */
    @OptIn(ExperimentalContracts::class)
    suspend inline fun assertInputParamsNotNull(params: InputParams? = null): InputParams {
        contract {
            returns() implies (params != null)
        }

        return params?.let { params } ?: throw MissingUseCaseInputParamsException(this)
    }
}
