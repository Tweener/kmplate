package com.tweener.changehere._internal.libs.sonner

import com.dokar.sonner.ToasterState
import com.tweener.changehere.presentation.mapper.ToastMessageMapper
import com.tweener.changehere.presentation.model.ToastMessage
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

/**
 * @author Vivien Mahe
 * @since 15/03/2024
 */

fun ToasterState.show(toastMessageMapper: ToastMessageMapper, message: ToastMessage) {
    CoroutineScope(Dispatchers.IO).launch {
        show(toastMessageMapper.convertToUiModel(message))
    }
}
