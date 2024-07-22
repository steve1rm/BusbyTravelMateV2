package me.androidbox.core.presentation

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform