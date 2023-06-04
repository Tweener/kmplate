package com.tweener.kmmtemplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform