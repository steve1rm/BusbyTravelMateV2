package me.androidbox.core.presentation

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val pair = 1 to "one"
        pair.first
        pair.second

        return "Hello, ${platform.name}!"
    }
}