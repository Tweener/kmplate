package com.tweener.changehere.domain.usecase.user

import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase
import com.tweener.common._internal.kotlinextensions.now
import kotlinx.datetime.LocalDateTime

/**
 * @author Vivien Mahe
 * @since 10/01/2024
 */
class UpdateLastAskForAppReviewDateUseCase(
    private val userRepository: UserRepository,
) : CompletableUseCase<Nothing>() {

    override suspend fun buildUseCase(params: Nothing?) {
        userRepository.setLastAskForAppReviewDate(UserRepository.InputParams.SetLastAskForAppReviewDate(date = LocalDateTime.now()))
    }
}
