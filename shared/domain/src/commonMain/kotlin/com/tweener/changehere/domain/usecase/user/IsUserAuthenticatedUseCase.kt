package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.StreamUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */
class IsUserAuthenticatedUseCase(
    private val userRepository: UserRepository,
) : StreamUseCase<Nothing, IsUserAuthenticatedUseCase.OutputParams>() {

    class OutputParams(
        val authenticated: Boolean
    )

    override suspend fun buildUseCase(inputParams: Nothing?): Flow<OutputParams> =
        userRepository
            .isAuthenticated()
            .map { it.authenticated }
            .catch { emit(false) }
            .map { OutputParams(authenticated = it) }
}
