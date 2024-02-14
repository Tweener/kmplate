package com.tweener.changehere._internal.di

import org.kodein.di.Copy
import org.kodein.di.DI

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */

fun sharedIosDI() = DI {
    import(sharedIosModule())
    extend(di = sharedDI(), copy = Copy.All)
}

fun sharedIosModule() = DI.Module("sharedIosModule") {
    // Add here any specific iOS injections
}
