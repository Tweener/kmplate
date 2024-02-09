package com.tweener.changehere.android._internal.di.module.domain

import com.tweener.changehere.domain.usecase.config.LoadAppConfigUseCase
import com.tweener.changehere.domain.usecase.featureflag.GetFeatureFlagUseCase
import com.tweener.changehere.domain.usecase.settings.GetDarkModeUseCase
import com.tweener.changehere.domain.usecase.settings.SetDarkModeUseCase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val useCaseModule by DI.Module(name = "UseCase Module") {

    // Config
    bindProvider {
        LoadAppConfigUseCase(
            appConfigurationRepository = instance(),
        )
    }

    // Feature Flags
    bindProvider { GetFeatureFlagUseCase(featureFlagRepository = instance()) }

    // Settings & permissions
    bindProvider { SetDarkModeUseCase(settingsRepository = instance()) }
    bindProvider { GetDarkModeUseCase(settingsRepository = instance()) }

}
