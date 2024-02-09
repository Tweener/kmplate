package com.tweener.changehere.android.screen

import androidx.lifecycle.ViewModel
import com.tweener.changehere.domain.usecase.config.LoadAppConfigUseCase

/**
 * @author Vivien Mahe
 * @since 05/06/2023
 */
class MainViewModel(
    private val loadAppConfigUseCase: LoadAppConfigUseCase,
) : ViewModel() {
}
