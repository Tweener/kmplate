package com.tweener.changehere.data.source.firebase.firestore.datasource

import com.tweener.changehere.data.source.firebase.firestore.model.FirestoreUserModel
import com.tweener.firebase.firestore.FirestoreService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * @author Vivien Mahe
 * @since 15/01/2024
 */
class FirestoreUsersDataSource(
    private val firestoreService: FirestoreService,
) {

    companion object {
        private const val USERS_COLLECTION_NAME = "users"
        // TODO Add here all user's properties
    }

    suspend fun getUser(id: String): FirestoreUserModel =
        firestoreService.get<FirestoreUserModel>(collection = USERS_COLLECTION_NAME, id = id)

    fun getUserAsFlow(id: String): Flow<FirestoreUserModel> =
        firestoreService.getAsFlow<FirestoreUserModel>(collection = USERS_COLLECTION_NAME, id = id).map { it.copy(id = id) }

    suspend fun createUser(email: String) {
        firestoreService.create<FirestoreUserModel>(
            collection = USERS_COLLECTION_NAME,
            id = email,
            data = hashMapOf(
                // TODO Add here user properties with default values
            )
        )
    }

    suspend fun updateUser(email: String) {
        firestoreService.update(
            collection = USERS_COLLECTION_NAME,
            id = email,
            data = hashMapOf(
                // TODO Add here user properties with updated values
            )
        )
    }

    suspend fun deleteUser(email: String) {
        firestoreService.delete(
            collection = USERS_COLLECTION_NAME,
            id = email,
        )
    }
}
