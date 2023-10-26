package com.tweener.changehere.data._internal

import platform.Foundation.NSUUID

/**
 * @author Vivien Mahe
 * @since 27/08/2023
 */

actual fun generateRandomUUID(): String = NSUUID().UUIDString()
