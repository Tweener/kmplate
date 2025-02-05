package com.tweener.changehere.presentation._internal.di

import com.tweener.passage.Passage
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

/**
 * @author Vivien Mahe
 * @since 20/11/2024
 */
class PassageHelper : KoinComponent {

    private val passage: Passage by inject()

    fun handle(url: String): Boolean =
        passage.handleLink(url = url)
}
