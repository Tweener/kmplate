package com.tweener.changehere._internal.di

import com.tweener.changehere.Test
import org.kodein.di.DI
import org.kodein.di.direct
import org.kodein.di.instance

/**
 * @author Vivien Mahe
 * @since 14/02/2024
 */
interface Dependencies {
    fun provideTest(): Test
}

class DependenciesImpl : Dependencies {
    private val di: DI by lazy { sharedIosDI() }

    override fun provideTest(): Test = di.direct.instance()
}
