package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 21/01/2024
 */
class SignOutUserUseCase(
    private val userRepository: UserRepository,
) : CompletableUseCase<Nothing>() {

    override suspend fun buildUseCase(params: Nothing?) {
        userRepository.signOut()
    }
}
