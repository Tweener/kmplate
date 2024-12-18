package com.tweener.changehere.domain._internal.di

import com.tweener.changehere.domain.usecase.config.GetAppRatingAskPeriodMonthsUseCase
import com.tweener.changehere.domain.usecase.config.LoadAppConfigUseCase
import com.tweener.changehere.domain.usecase.featureflag.GetFeatureFlagUseCase
import com.tweener.changehere.domain.usecase.settings.GetDarkModeUseCase
import com.tweener.changehere.domain.usecase.settings.SetDarkModeUseCase
import com.tweener.changehere.domain.usecase.user.DeleteUserUseCase
import com.tweener.changehere.domain.usecase.user.GetUserUseCase
import com.tweener.changehere.domain.usecase.user.IsUserAuthenticatedUseCase
import com.tweener.changehere.domain.usecase.user.ShouldAskForAppReviewUseCase
import com.tweener.changehere.domain.usecase.user.SignOutUserUseCase
import com.tweener.changehere.domain.usecase.user.UpdateLastAskForAppReviewDateUseCase
import com.tweener.changehere.domain.usecase.user.UpdateUserUseCase
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val useCaseModule = module {

    // Config
    factory {
        LoadAppConfigUseCase(
            appConfigurationRepository = get(),
        )
    }
    factory { GetAppRatingAskPeriodMonthsUseCase(appConfigurationRepository = get()) }

    // User
    factory { GetUserUseCase(userRepository = get()) }
    factory { IsUserAuthenticatedUseCase(userRepository = get()) }
    factory { ShouldAskForAppReviewUseCase(userRepository = get(), getAppRatingAskPeriodMonthsUseCase = get()) }
    factory { UpdateLastAskForAppReviewDateUseCase(userRepository = get()) }
    factory { UpdateUserUseCase(userRepository = get()) }
    factory { SignOutUserUseCase(userRepository = get()) }
    factory { DeleteUserUseCase(userRepository = get()) }

    // Feature Flags
    factory { GetFeatureFlagUseCase(featureFlagRepository = get()) }

    // Settings & permissions
    factory { SetDarkModeUseCase(settingsRepository = get()) }
    factory { GetDarkModeUseCase(settingsRepository = get()) }

}
