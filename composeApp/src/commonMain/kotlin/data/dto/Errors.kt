package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class Errors(
    val domain: String = "",
    val message: String = "",
    val reason: String = ""
)