package com.tweener.changehere.data.repository

import com.tweener.changehere.domain.Platform
import com.tweener.changehere.domain.repository.PlatformRepository

/**
 * @author Vivien Mahe
 * @since 04/06/2023
 */
class PlatformRepositoryImpl : PlatformRepository {

    override fun getPlatform(): Platform = providePlatform()
}

expect fun providePlatform(): Platform
