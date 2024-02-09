package com.tweener.changehere.data.source.firebase.firestore.model

import com.tweener.firebase.firestore.model.FirestoreModel
import kotlinx.serialization.Serializable

/**
 * @author Vivien Mahe
 * @since 15/01/2024
 */

@Serializable
data class FirestoreUserModel(
    override var id: String,
    val framesGenerationsNumber: Int,
    val lastFrameGenerationDate: String?,
) : FirestoreModel()
