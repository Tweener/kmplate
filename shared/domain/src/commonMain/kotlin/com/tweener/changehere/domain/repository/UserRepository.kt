package com.tweener.changehere.domain.repository

import com.tweener.changehere.domain.entity.User
import kotlinx.coroutines.flow.Flow
import kotlinx.datetime.LocalDateTime

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */
interface UserRepository {

    sealed class InputParams {
        data object UpdateAuthenticatedUser : InputParams() // TODO Update this object to a class and add the user's properties to update
        data class SetLastAskForAppReviewDate(val date: LocalDateTime) : InputParams()
    }

    sealed class OutputParams {
        data class IsAuthenticated(val authenticated: Boolean) : OutputParams()
        data class GetAuthenticatedUser(val user: User) : OutputParams()
        data class GetLastAskForAppReviewDate(val date: LocalDateTime?) : OutputParams()
    }

    suspend fun isAuthenticated(): Flow<OutputParams.IsAuthenticated>

    suspend fun getAuthenticatedUser(): OutputParams.GetAuthenticatedUser

    suspend fun updateAuthenticatedUser(inputParams: InputParams.UpdateAuthenticatedUser)

    suspend fun setLastAskForAppReviewDate(inputParams: InputParams.SetLastAskForAppReviewDate)

    suspend fun getLastAskForAppReviewDate(): OutputParams.GetLastAskForAppReviewDate

    suspend fun delete()

    suspend fun signOut()
}
