package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.error.UserSignInWithCredentialException
import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 15/01/2024
 */
class AuthenticateUserUseCase(
    private val userRepository: UserRepository,
) : CompletableUseCase<AuthenticateUserUseCase.InputParams>() {

    class InputParams(
        val idToken: String,
    )

    override suspend fun buildUseCase(inputParams: InputParams?) {
        val params = assertInputParamsNotNull(inputParams)

        val isUserAuthenticated = userRepository.authenticate(UserRepository.InputParams.Authenticate(idToken = params.idToken)).success

        if (isUserAuthenticated.not()) {
            throw UserSignInWithCredentialException(idToken = params.idToken)
        }
    }
}
