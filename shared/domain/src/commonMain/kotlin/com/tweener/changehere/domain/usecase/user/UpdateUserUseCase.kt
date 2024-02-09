package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 15/01/2024
 */
class UpdateUserUseCase(
    private val userRepository: UserRepository,
) : CompletableUseCase<UpdateUserUseCase.InputParams>() {

    // TODO Add here the user's properties to update
    class InputParams

    override suspend fun buildUseCase(params: InputParams?) {
        assertInputParamsNotNull(params)

        userRepository.updateAuthenticatedUser(
            UserRepository.InputParams.UpdateAuthenticatedUser
        )
    }
}
