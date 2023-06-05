package com.tweener.changehere.data

import com.tweener.changehere.domain.Platform
import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
}

actual fun providePlatform(): Platform = IOSPlatform()
