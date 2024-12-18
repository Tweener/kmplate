package com.tweener.changehere.presentation.screen.home

import androidx.lifecycle.viewModelScope
import com.tweener.changehere.presentation._internal.viewmodel.ViewModel
import com.tweener.changehere.presentation.screen.home.model.HomeUiAction
import com.tweener.kmpkit.kotlinextensions.now
import io.github.aakira.napier.Napier
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */
class HomeViewModel : ViewModel() {

    // region Observable properties

    private val _openDetailScreen = MutableSharedFlow<String>() // id
    val openDetailScreen: SharedFlow<String> = _openDetailScreen.asSharedFlow()

    private val _setOneOffAlarm = MutableSharedFlow<LocalDateTime>() // alarm dateTime
    val setOneOffAlarm: SharedFlow<LocalDateTime> = _setOneOffAlarm.asSharedFlow()

    private val _setRepeatingAlarm = MutableSharedFlow<LocalDateTime>() // alarm dateTime
    val setRepeatingAlarm: SharedFlow<LocalDateTime> = _setRepeatingAlarm.asSharedFlow()

    // endregion Observable properties

    fun onUiAction(uiAction: HomeUiAction) {
        Napier.d { "UiAction received: $uiAction" }

        when (uiAction) {
            is HomeUiAction.OpenDetailScreenClick -> onDetailButtonClicked()
            is HomeUiAction.SetOneOffAlarm -> onSetOneOffAlarmClicked()
            is HomeUiAction.SetRepeatingAlarm -> onSetRepeatingAlarmClicked()
        }
    }

    private fun onDetailButtonClicked() {
        viewModelScope.launch {
            _openDetailScreen.emit("1")
        }
    }

    private fun onSetOneOffAlarmClicked() {
        viewModelScope.launch {
            // Set a one-off alarm in 5 seconds
            val now = LocalDateTime.now()
            _setOneOffAlarm.emit(LocalDateTime(date = now.date, time = LocalTime(hour = now.hour, minute = now.minute, second = now.second + 5)))
        }
    }

    private fun onSetRepeatingAlarmClicked() {
        viewModelScope.launch {
            // Set a repeating alarm every day at 9:30
            val now = LocalDateTime.now()
            _setRepeatingAlarm.emit(LocalDateTime(date = now.date, time = LocalTime(hour = 9, minute = 30)))
        }
    }
}
