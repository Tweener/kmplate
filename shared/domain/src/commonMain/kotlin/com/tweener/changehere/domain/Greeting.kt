package com.tweener.changehere.domain

import com.tweener.changehere.domain.repository.PlatformRepository

class Greeting(
    platformRepository: PlatformRepository
) {
    private val platform: Platform = platformRepository.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
