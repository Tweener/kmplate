package com.tweener.changehere.data.repository

import com.tweener.changehere.data._internal.libs.room.RoomDatabaseHelper
import com.tweener.changehere.data.source.firebase.firestore.datasource.FirestoreUsersDataSource
import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
import com.tweener.changehere.data.source.room.datasource.RoomExampleDataSource
import com.tweener.changehere.domain.entity.User
import com.tweener.changehere.domain.error.UserNotAuthenticatedException
import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.passage.Passage
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.datetime.LocalDateTime

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */
class UserRepositoryImpl(
    private val passage: Passage,
    private val roomDatabaseHelper: RoomDatabaseHelper,
    private val roomExampleDataSource: RoomExampleDataSource,
    private val localStorageDataSource: LocalStorageDataSource,
    private val firestoreUsersDataSource: FirestoreUsersDataSource,
) : UserRepository {

    companion object {
        private const val LOCAL_STORAGE_KEY_LAST_ASK_APP_REVIEW_DATE = "lastAskForAppReviewDate"
    }

    override suspend fun isAuthenticated(): Flow<UserRepository.OutputParams.IsAuthenticated> =
        passage
            .isUserLoggedIn()
            .map { UserRepository.OutputParams.IsAuthenticated(authenticated = it) }

    override suspend fun getAuthenticatedUser(): UserRepository.OutputParams.GetAuthenticatedUser {
        val email = passage.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()

        val firestoreUser = try {
            firestoreUsersDataSource.getUser(id = email)
        } catch (throwable: Throwable) {
            // User is not yet created in Firestore, let's create it
            firestoreUsersDataSource.createUser(email = email)
            firestoreUsersDataSource.getUser(id = email)
        }

        val user = User(
            email = email,
        )

        return UserRepository.OutputParams.GetAuthenticatedUser(user = user)
    }

    override suspend fun updateAuthenticatedUser(inputParams: UserRepository.InputParams.UpdateAuthenticatedUser) {
        val email = passage.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()
        firestoreUsersDataSource.updateUser(email = email)
    }

    override suspend fun setLastAskForAppReviewDate(inputParams: UserRepository.InputParams.SetLastAskForAppReviewDate) {
        localStorageDataSource.setString(LOCAL_STORAGE_KEY_LAST_ASK_APP_REVIEW_DATE, inputParams.date.toString())
    }

    override suspend fun getLastAskForAppReviewDate(): UserRepository.OutputParams.GetLastAskForAppReviewDate {
        val lastAskForAppReviewDate = localStorageDataSource.getString(LOCAL_STORAGE_KEY_LAST_ASK_APP_REVIEW_DATE)
        return UserRepository.OutputParams.GetLastAskForAppReviewDate(date = lastAskForAppReviewDate?.let { LocalDateTime.parse(it) })
    }

    override suspend fun delete() {
        val email = passage.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()
        firestoreUsersDataSource.deleteUser(email = email)
        signOut()
    }

    override suspend fun signOut() {
        passage.signOut()
    }
}
