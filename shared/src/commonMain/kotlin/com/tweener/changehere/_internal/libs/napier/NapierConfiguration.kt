package com.tweener.changehere._internal.libs.napier

import com.tweener.firebase.crashlytics.CrashlyticsService
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 * @author Vivien Mahe
 * @since 21/09/2023
 */
class NapierConfiguration(
    private val isDebug: Boolean,
    private val crashlyticsAntilog: CrashlyticsAntilog,
    private val crashlyticsService: CrashlyticsService,
) {

    fun init() {
        crashlyticsService.getCrashlytics().setCrashlyticsCollectionEnabled(isDebug.not())

        when (isDebug) {
            true -> Napier.base(DebugAntilog())
            false -> Napier.base(crashlyticsAntilog)
        }
    }
}
