package com.tweener.changehere.presentation._internal.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tweener.changehere.presentation.PresentationConstants.FLOWS_DEBOUNCE_DELAY
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlin.time.Duration

/**
 * @author Vivien Mahe
 * @since 02/09/2024
 */

abstract class ViewModel : ViewModel() {

    fun <T> Flow<T>.launchInEagerly(initialValue: T): Job =
        this
            .conflate()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = initialValue,
            )
            .launchIn(viewModelScope)

    fun <T> Flow<T>.launchInLazily(initialValue: T): Job =
        this
            .conflate()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Lazily,
                initialValue = initialValue,
            )
            .launchIn(viewModelScope)

    fun <T> Flow<T>.launchInWhileSubscribed(initialValue: T, stopTimeoutMillis: Long = 5_000): Job =
        this
            .conflate()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = stopTimeoutMillis),
                initialValue = initialValue,
            )
            .launchIn(viewModelScope)

    @OptIn(FlowPreview::class)
    fun <T> Flow<T>.onEachDistinct(timeout: Duration = FLOWS_DEBOUNCE_DELAY, action: suspend (T) -> Unit): Flow<T> =
        this
            .debounce(timeout)
            .distinctUntilChanged()
            .onEach { action(it) }
}
