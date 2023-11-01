package com.tweener.changehere.android._internal.libs.napier

import com.google.firebase.crashlytics.FirebaseCrashlytics
import io.github.aakira.napier.Antilog
import io.github.aakira.napier.LogLevel

/**
 * @author Vivien Mahe
 * @since 21/09/2023
 */
class CrashlyticsAntilog : Antilog() {

    override fun performLog(priority: LogLevel, tag: String?, throwable: Throwable?, message: String?) {
        // send only warning and error logs
        if (priority < LogLevel.WARNING) return

        throwable?.let { FirebaseCrashlytics.getInstance().recordException(it) }
    }
}
