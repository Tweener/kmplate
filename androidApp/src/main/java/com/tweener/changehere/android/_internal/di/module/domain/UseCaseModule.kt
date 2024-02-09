package com.tweener.changehere.android._internal.di.module.domain

import com.tweener.changehere.domain.usecase.featureflag.GetFeatureFlagUseCase
import org.kodein.di.DI
import org.kodein.di.bindProvider
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val useCaseModule by DI.Module(name = "UseCase Module") {

    // Feature Flags
    bindProvider { GetFeatureFlagUseCase(featureFlagRepository = instance()) }


}
