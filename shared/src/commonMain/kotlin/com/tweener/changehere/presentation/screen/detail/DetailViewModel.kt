package com.tweener.changehere.presentation.screen.detail

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */
class DetailViewModel : ViewModel() {

    // region Observable properties

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage: SharedFlow<String> = _toastMessage.asSharedFlow()

    // endregion Observable properties

    private lateinit var id: String

    fun initViewModel(id: String) {
        this.id = id
    }

    fun onShowToastButtonClicked() {
        viewModelScope.launch {
            _toastMessage.emit("Load data for detail ID: $id")
        }
    }
}
