package com.tweener.changehere.presentation

import com.tweener.changehere.domain.usecase.config.LoadAppConfigUseCase
import dev.icerock.moko.mvvm.viewmodel.ViewModel

/**
 * @author Vivien Mahe
 * @since 10/02/2024
 */
class MainViewModel(
    private val loadAppConfigUseCase: LoadAppConfigUseCase,
) : ViewModel() {
}
