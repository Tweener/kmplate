package com.tweener.changehere.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.tweener.changehere.presentation._internal.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */
class HomeViewModel : ViewModel() {

    // region Observable properties

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage: SharedFlow<String> = _toastMessage.asSharedFlow()

    private val _openDetailScreen = MutableSharedFlow<String>() // id
    val openDetailScreen: SharedFlow<String> = _openDetailScreen.asSharedFlow()

    // endregion Observable properties

    fun onDetailButtonClicked() {
        viewModelScope.launch {
            _openDetailScreen.emit("1")
        }
    }
}
