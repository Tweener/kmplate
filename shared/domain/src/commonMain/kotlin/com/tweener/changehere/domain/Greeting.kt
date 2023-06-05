package com.tweener.changehere.domain

class Greeting(
    platformRepository: PlatformRepository
) {
    private val platform: Platform = platformRepository.getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}
