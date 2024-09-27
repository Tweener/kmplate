package com.tweener.changehere._internal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

/**
 * @author Vivien Mahe
 * @since 02/09/2024
 */

abstract class ViewModel : ViewModel() {

    fun <T> Flow<T>.stateInEagerly(initialValue: T): StateFlow<T> =
        stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = initialValue,
        )

    fun <T> Flow<T>.stateInLazily(initialValue: T): StateFlow<T> =
        stateIn(
            scope = viewModelScope,
            started = SharingStarted.Lazily,
            initialValue = initialValue,
        )

    fun <T> Flow<T>.stateInWhileSubscribed(initialValue: T, stopTimeoutMillis: Long = 5_000): StateFlow<T> =
        stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
            initialValue = initialValue,
        )
}
