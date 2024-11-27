package com.tweener.changehere.presentation.screen.home.model

/**
 * @author Vivien Mahe
 * @since 27/11/2024
 */
sealed class HomeUiAction {
    data object OpenDetailScreenClick : HomeUiAction()
    data object SetOneOffAlarm : HomeUiAction()
    data object SetRepeatingAlarm : HomeUiAction()
}
