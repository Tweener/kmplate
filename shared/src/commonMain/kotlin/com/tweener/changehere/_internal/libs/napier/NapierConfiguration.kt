package com.tweener.changehere._internal.libs.napier

import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

/**
 * @author Vivien Mahe
 * @since 21/09/2023
 */
class NapierConfiguration {

    fun init() {
        Napier.base(DebugAntilog())
//        when (BuildConfig.DEBUG) {
//            true -> Napier.base(DebugAntilog())
//            false -> Napier.base(CrashlyticsAntilog())
//        }
    }
}
