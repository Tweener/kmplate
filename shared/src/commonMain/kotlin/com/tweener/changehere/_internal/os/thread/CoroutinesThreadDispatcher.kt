package com.tweener.changehere._internal.os.thread

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

/**
 * @author Vivien Mahe
 * @since 07/09/2023
 */
class CoroutinesThreadDispatcher : ThreadDispatcher<CoroutineDispatcher> {

    override fun io(): CoroutineDispatcher = Dispatchers.IO

    override fun ui(): CoroutineDispatcher = Dispatchers.Main
}
