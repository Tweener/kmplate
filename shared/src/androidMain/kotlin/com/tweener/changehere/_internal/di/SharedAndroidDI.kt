package com.tweener.changehere._internal.di

import android.content.Context
import com.tweener.changehere._internal.libs.napier.NapierConfiguration
import com.tweener.common.os.notification.channel.NotificationChannelRegister
import com.tweener.common.os.notification.notification.NotificationNotifier
import com.tweener.common.os.permission.PermissionChecker
import java.util.Locale
import org.kodein.di.Copy
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

fun sharedAndroidDI(context: Context) = DI {
    import(sharedAndroidModule(context = context))
    extend(di = sharedDI(), copy = Copy.All)
}

fun sharedAndroidModule(context: Context) = DI.Module("sharedAndroidModule") {
    bindSingleton { context }
    bindSingleton { Locale.getDefault() }

    bindSingleton { NapierConfiguration() }
    bindSingleton { PermissionChecker(context = instance()) }

    // Notifications
    bindSingleton { NotificationChannelRegister(context = instance()) }
    bindSingleton { NotificationNotifier(context = instance(), permissionChecker = instance()) }
}
