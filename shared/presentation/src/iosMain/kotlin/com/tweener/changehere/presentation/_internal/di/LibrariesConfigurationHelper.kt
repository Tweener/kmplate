package com.tweener.changehere.presentation._internal.di

import com.tweener.changehere.presentation._internal.libs.LibrariesConfiguration
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * @author Vivien Mahe
 * @since 22/05/2024
 */

class LibrariesConfigurationHelper : KoinComponent {

    private val librariesConfiguration: LibrariesConfiguration by inject()

    fun initConfigurations() {
        librariesConfiguration.init()
    }
}
