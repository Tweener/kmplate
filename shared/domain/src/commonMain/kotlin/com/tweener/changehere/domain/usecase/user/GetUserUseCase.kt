package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.entity.User
import com.tweener.changehere.domain.error.UserNotAuthenticatedException
import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.SingleUseCase

/**
 * @author Vivien Mahe
 * @since 07/11/2023
 */
class GetUserUseCase(
    private val userRepository: UserRepository,
) : SingleUseCase<Nothing, GetUserUseCase.OutputParams>() {

    class OutputParams(
        val user: User
    )

    override suspend fun buildUseCase(params: Nothing?): OutputParams =
        OutputParams(user = userRepository.getAuthenticatedUser().user)

    suspend inline fun assertUserLoggedIn() {
        try {
            this.execute()
        } catch (throwable: UserNotAuthenticatedException) {
            throw throwable
        }
    }
}
