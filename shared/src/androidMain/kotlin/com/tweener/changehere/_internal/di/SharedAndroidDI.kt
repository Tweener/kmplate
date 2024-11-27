package com.tweener.changehere._internal.di

import android.app.NotificationManager
import android.content.Context
import androidx.preference.PreferenceManager
import com.russhwolf.settings.ObservableSettings
import com.russhwolf.settings.SharedPreferencesSettings
import com.russhwolf.settings.coroutines.toFlowSettings
import com.tweener.alarmee.channel.AlarmeeNotificationChannel
import com.tweener.alarmee.configuration.AlarmeeAndroidPlatformConfiguration
import com.tweener.alarmee.configuration.AlarmeePlatformConfiguration
import com.tweener.changehere.R
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

    // Alarmee
    factory<AlarmeePlatformConfiguration> {
        AlarmeeAndroidPlatformConfiguration(
            notificationIconResId = R.drawable.ic_stat_name,
            notificationChannels = listOf(
                AlarmeeNotificationChannel(
                    id = "dailyNewsChannelId",
                    name = "Daily news notifications",
                    importance = NotificationManager.IMPORTANCE_HIGH
                ),
                AlarmeeNotificationChannel(
                    id = "breakingNewsChannelId",
                    name = "Breaking news notifications",
                    importance = NotificationManager.IMPORTANCE_LOW
                ),
            )
        )
    }
}
