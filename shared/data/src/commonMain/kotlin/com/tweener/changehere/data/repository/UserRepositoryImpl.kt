package com.tweener.changehere.data.repository

import com.tweener.changehere.data.source.firebase.firestore.datasource.FirestoreUsersDataSource
import com.tweener.changehere.data.source.local.datasource.LocalStorageDataSource
import com.tweener.changehere.domain.entity.User
import com.tweener.changehere.domain.error.UserNotAuthenticatedException
import com.tweener.changehere.domain.repository.UserRepository
import com.tweener.firebase.auth.datasource.FirebaseAuthDataSource
import kotlinx.datetime.LocalDateTime

/**
 * @author Vivien Mahe
 * @since 17/10/2023
 */
class UserRepositoryImpl(
    private val localStorageDataSource: LocalStorageDataSource,
    private val firebaseAuthDataSource: FirebaseAuthDataSource,
    private val firestoreUsersDataSource: FirestoreUsersDataSource,
) : UserRepository {

    companion object {
        private const val LOCAL_STORAGE_KEY_LAST_ASK_APP_REVIEW_DATE = "lastAskForAppReviewDate"
    }

    override suspend fun authenticate(inputParams: UserRepository.InputParams.Authenticate): UserRepository.OutputParams.Authenticate {
        val user = firebaseAuthDataSource.authenticateWithGoogleIdToken(idToken = inputParams.idToken)
        return UserRepository.OutputParams.Authenticate(success = user != null)
    }

    override suspend fun isAuthenticated(): UserRepository.OutputParams.IsAuthenticated =
        UserRepository.OutputParams.IsAuthenticated(authenticated = firebaseAuthDataSource.isUserLoggedIn())

    override suspend fun getAuthenticatedUser(): UserRepository.OutputParams.GetAuthenticatedUser {
        val email = firebaseAuthDataSource.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()

        val firestoreUser = try {
            firestoreUsersDataSource.getUser(email = email)
        } catch (throwable: Throwable) {
            // User is not yet created in Firestore, let's create it
            firestoreUsersDataSource.createUser(email = email)
            firestoreUsersDataSource.getUser(email = email)
        }

        val user = User(
            email = email,
        )

        return UserRepository.OutputParams.GetAuthenticatedUser(user = user)
    }

    override suspend fun updateAuthenticatedUser(inputParams: UserRepository.InputParams.UpdateAuthenticatedUser) {
        val email = firebaseAuthDataSource.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()
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
        val email = firebaseAuthDataSource.getCurrentUser()?.email ?: throw UserNotAuthenticatedException()
        firestoreUsersDataSource.deleteUser(email = email)
        signOut()
    }

    override suspend fun signOut() {
        firebaseAuthDataSource.signOut()
    }
}
