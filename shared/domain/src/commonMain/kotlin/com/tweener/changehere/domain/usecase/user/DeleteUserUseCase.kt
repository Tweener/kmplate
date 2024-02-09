package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 26/01/2024
 */
class DeleteUserUseCase(
    private val userRepository: UserRepository,
) : CompletableUseCase<Nothing>() {

    override suspend fun buildUseCase(params: Nothing?) {
        try {
            userRepository.delete()
        } catch (throwable: Throwable) {
            // User might not be logged in for instance, or any other error. Do nothing
        }
    }
}
