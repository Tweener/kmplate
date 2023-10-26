package com.tweener.changehere.data.repository

import com.tweener.changehere.domain.Platform

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}

actual fun providePlatform(): Platform = AndroidPlatform()
