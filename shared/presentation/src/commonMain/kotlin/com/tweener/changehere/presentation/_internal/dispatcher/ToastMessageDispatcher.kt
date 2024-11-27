package com.tweener.changehere.presentation._internal.dispatcher

import com.tweener.changehere.presentation.mapper.ToastMessageMapper
import com.tweener.changehere.presentation.model.ToastMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * @author Vivien Mahe
 * @since 26/11/2024
 */
class ToastMessageDispatcher(
    private val toastMessageMapper: ToastMessageMapper
) {

    private val _toastMessage = MutableSharedFlow<String>()
    val toastMessage: SharedFlow<String> = _toastMessage.asSharedFlow()

    private val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    fun postMessage(toastMessage: ToastMessage) {
        scope.launch {
            val message = toastMessageMapper.convertToUiModel(toastMessage)
            _toastMessage.emit(message)
        }
    }
}
