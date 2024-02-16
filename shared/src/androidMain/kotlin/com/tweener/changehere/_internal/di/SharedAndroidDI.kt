package com.tweener.changehere._internal.di

import android.content.Context
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

    // Notifications
    single { NotificationChannelRegister(context = get()) }
}
