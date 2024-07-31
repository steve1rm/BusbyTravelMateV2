package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val code: String,
    val details: String
)