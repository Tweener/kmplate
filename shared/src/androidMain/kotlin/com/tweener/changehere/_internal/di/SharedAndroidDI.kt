package com.tweener.changehere._internal.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import org.koin.dsl.module
import java.util.Locale

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

fun sharedAndroidModule(context: Context) = module {

    includes(sharedModule)

    single { context }
    single { Locale.getDefault() }

    // Multiplatform Settings
    single<ObservableSettings> { SharedPreferencesSettings(PreferenceManager.getDefaultSharedPreferences(context)) }
    single { get<ObservableSettings>().toFlowSettings() }
}
