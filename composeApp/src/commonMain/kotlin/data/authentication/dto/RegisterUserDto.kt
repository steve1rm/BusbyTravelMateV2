package data.authentication.dto

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserDto(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)