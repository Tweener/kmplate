package com.tweener.changehere.android._internal.di.module.domain

import com.tweener.changehere.domain.usecase.config.GetAppRatingAskPeriodMonthsUseCase
import com.tweener.changehere.domain.usecase.config.LoadAppConfigUseCase
import com.tweener.changehere.domain.usecase.featureflag.GetFeatureFlagUseCase
import com.tweener.changehere.domain.usecase.settings.GetDarkModeUseCase
import com.tweener.changehere.domain.usecase.settings.SetDarkModeUseCase
import com.tweener.changehere.domain.usecase.user.AuthenticateUserUseCase
import com.tweener.changehere.domain.usecase.user.DeleteUserUseCase
import com.tweener.changehere.domain.usecase.user.GetUserUseCase
import com.tweener.changehere.domain.usecase.user.IsUserAuthenticatedInUseCase
import com.tweener.changehere.domain.usecase.user.ShouldAskForAppReviewUseCase
import com.tweener.changehere.domain.usecase.user.SignOutUserUseCase
import com.tweener.changehere.domain.usecase.user.UpdateLastAskForAppReviewDateUseCase
import com.tweener.changehere.domain.usecase.user.UpdateUserUseCase
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
    bindProvider { GetAppRatingAskPeriodMonthsUseCase(appConfigurationRepository = instance()) }

    // User
    bindProvider { GetUserUseCase(userRepository = instance()) }
    bindProvider { IsUserAuthenticatedInUseCase(userRepository = instance()) }
    bindProvider { ShouldAskForAppReviewUseCase(userRepository = instance(), getAppRatingAskPeriodMonthsUseCase = instance()) }
    bindProvider { UpdateLastAskForAppReviewDateUseCase(userRepository = instance()) }
    bindProvider { AuthenticateUserUseCase(userRepository = instance()) }
    bindProvider { UpdateUserUseCase(userRepository = instance()) }
    bindProvider { SignOutUserUseCase(userRepository = instance()) }
    bindProvider { DeleteUserUseCase(userRepository = instance()) }

    // Feature Flags
    bindProvider { GetFeatureFlagUseCase(featureFlagRepository = instance()) }

    // Settings & permissions
    bindProvider { SetDarkModeUseCase(settingsRepository = instance()) }
    bindProvider { GetDarkModeUseCase(settingsRepository = instance()) }

}
