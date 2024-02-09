package com.tweener.changehere.domain.usecase.config

import com.tweener.changehere.domain.repository.AppConfigurationRepository
import com.tweener.changehere.domain.usecase.CompletableUseCase

/**
 * @author Vivien Mahe
 * @since 09/12/2023
 */
class LoadAppConfigUseCase(
    private val appConfigurationRepository: AppConfigurationRepository,
) : CompletableUseCase<Nothing>() {

    override suspend fun buildUseCase(params: Nothing?) {
        appConfigurationRepository.getAppConfiguration()

        // TODO Add here any usecase or repository for app configuration, like Remote Config for instance
    }
}
