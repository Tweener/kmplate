package com.tweener.changehere.android._internal.libs.napier

import com.tweener.changehere.android.BuildConfig
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 * @author Vivien Mahe
 * @since 21/09/2023
 */
class NapierConfiguration {

    fun init() {
        when (BuildConfig.DEBUG) {
            true -> Napier.base(DebugAntilog())
            false -> Napier.base(CrashlyticsAntilog())
        }
    }
}
