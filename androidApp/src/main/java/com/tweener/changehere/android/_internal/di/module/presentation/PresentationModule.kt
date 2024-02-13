package com.tweener.changehere.android._internal.di.module.presentation

import com.tweener.changehere._internal.os.thread.CoroutinesThreadDispatcher
import org.kodein.di.DI
import org.kodein.di.bindSingleton

/**
 * @author Vivien Mahe
 * @since 01/11/2023
 */

val presentationModule by DI.Module("Presentation layer module") {

    bindSingleton { CoroutinesThreadDispatcher() }

    importOnce(uiMapperModule)

}
