package com.tweener.changehere.data

import com.tweener.changehere.domain.Platform
import com.tweener.changehere.domain.PlatformRepository

/**
 * @author Vivien Mahe
 * @since 04/06/2023
 */
class PlatformRepositoryImpl : PlatformRepository {

    override fun getPlatform(): Platform = providePlatform()
}

expect fun providePlatform(): Platform
