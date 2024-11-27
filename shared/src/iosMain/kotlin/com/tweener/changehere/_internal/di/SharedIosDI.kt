package com.tweener.changehere._internal.di

import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import com.tweener.alarmee.configuration.AlarmeeIosPlatformConfiguration
import com.tweener.alarmee.configuration.AlarmeePlatformConfiguration
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

/**
 * @author Vivien Mahe
 * @since 16/02/2024
 */

val sharedIosModule = module {

    includes(sharedModule)

    // Multiplatform Settings
    single<ObservableSettings> { NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults) }
    single { get<ObservableSettings>().toFlowSettings() }

    // Alarmee
    factory<AlarmeePlatformConfiguration> { AlarmeeIosPlatformConfiguration }
}
