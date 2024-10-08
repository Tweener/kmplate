package com.tweener.changehere.presentation._internal.libs.napier

import com.tweener.firebase.crashlytics.CrashlyticsService
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

/**
 * @author Vivien Mahe
 * @since 21/09/2023
 */
class CrashlyticsAntilog(
    private val crashlyticsService: CrashlyticsService,
) : Antilog() {

    override fun performLog(priority: LogLevel, tag: String?, throwable: Throwable?, message: String?) {
        // send only warning and error logs
        if (priority < LogLevel.WARNING) return

        message?.let { crashlyticsService.getCrashlytics().log(it) }
        throwable?.let { crashlyticsService.getCrashlytics().recordException(it) }
    }
}
