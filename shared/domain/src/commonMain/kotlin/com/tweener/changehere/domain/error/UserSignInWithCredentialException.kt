package com.tweener.changehere.domain.error

/**
 * @author Vivien Mahe
 * @since 15/01/2024
 */
class UserSignInWithCredentialException(idToken: String) : NoSuchElementException("Couldn't sign-in the user with Google ID token: $idToken")
