package com.tweener.changehere.android._internal.di.module.app

import com.tweener.changehere.android._internal.libs.napier.NapierConfiguration
import com.tweener.changehere.presentation._internal.libs.coil.CoilConfiguration
import com.tweener.common.os.notification.channel.NotificationChannelRegister
import com.tweener.common.os.notification.notification.NotificationNotifier
import com.tweener.common.os.permission.PermissionChecker
import org.kodein.di.DI
import org.kodein.di.bindSingleton
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val appModule by DI.Module(name = "Application Layer Module") {

    bindSingleton { NapierConfiguration() }
    bindSingleton { CoilConfiguration() }
    bindSingleton { PermissionChecker(context = instance()) }

    // Notifications
    bindSingleton { NotificationChannelRegister(context = instance()) }
    bindSingleton { NotificationNotifier(context = instance(), permissionChecker = instance()) }

}
