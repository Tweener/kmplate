package com.tweener.changehere._internal.di

import android.content.Context
import androidx.preference.PreferenceManager
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import com.tweener.common.os.notification.channel.NotificationChannelRegister
import com.tweener.common.os.permission.PermissionChecker
import java.util.Locale
import org.koin.dsl.module

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

fun sharedAndroidModule(context: Context) = module {

    includes(sharedModule)

    single { context }
    single { Locale.getDefault() }
    single { PermissionChecker(context = get()) }

    // Multiplatform Settings
    single<ObservableSettings> { SharedPreferencesSettings(PreferenceManager.getDefaultSharedPreferences(context)) }
    single { get<ObservableSettings>().toFlowSettings() }

    // Notifications
    single { NotificationChannelRegister(context = get()) }
}
