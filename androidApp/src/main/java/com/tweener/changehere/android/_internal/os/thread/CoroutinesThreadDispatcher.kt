package com.tweener.changehere.android._internal.os.thread

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

/**
 * @author Vivien Mahe
 * @since 07/09/2023
 */
class CoroutinesThreadDispatcher : ThreadDispatcher<CoroutineDispatcher> {

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun ui(): CoroutineDispatcher = Dispatchers.Main
}
