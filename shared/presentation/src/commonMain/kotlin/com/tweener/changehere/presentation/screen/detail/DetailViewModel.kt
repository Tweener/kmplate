package com.tweener.changehere.presentation.screen.detail

import androidx.lifecycle.viewModelScope
import com.tweener.changehere.presentation._internal.dispatcher.ToastMessageDispatcher
import com.tweener.changehere.presentation._internal.viewmodel.ViewModel
import com.tweener.changehere.presentation.model.ToastMessage
import com.tweener.changehere.presentation.screen.detail.mapper.DetailToastMessage
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch

/**
 * @author Vivien Mahe
 * @since 19/02/2024
 */
class DetailViewModel(
    private val toastMessageDispatcher: ToastMessageDispatcher,
) : ViewModel() {

    // region Observable properties

    private val _closeScreen = MutableSharedFlow<Unit>()
    val closeScreen: SharedFlow<Unit> = _closeScreen

    // endregion Observable properties

    private lateinit var id: String

    fun initViewModel(id: String) {
        this.id = id
    }

    /**
     * Called when the user taps the back button in the top bar.
     */
    fun onBackClicked() {
        Napier.d { "The user tapped on the back button in the top bar." }

        viewModelScope.launch {
            _closeScreen.emit(Unit)
        }
    }

    fun onShowToastButtonClicked() {
        viewModelScope.launch {
            postMessage(DetailToastMessage.LoadData(id = id))
        }
    }

    private fun postMessage(toastMessage: ToastMessage) {
        toastMessageDispatcher.postMessage(toastMessage)
    }
}
