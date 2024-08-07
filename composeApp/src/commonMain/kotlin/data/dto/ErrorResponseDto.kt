package data.dto


import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponseDto(
    val error: Error = Error()
)