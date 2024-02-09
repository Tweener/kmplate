package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.SingleUseCase

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */
class IsUserAuthenticatedInUseCase(
    private val userRepository: UserRepository
) : SingleUseCase<Nothing, IsUserAuthenticatedInUseCase.OutputParams>() {

    class OutputParams(
        val authenticated: Boolean
    )

    override suspend fun buildUseCase(params: Nothing?): OutputParams =
        OutputParams(authenticated = userRepository.isAuthenticated().authenticated)
}
