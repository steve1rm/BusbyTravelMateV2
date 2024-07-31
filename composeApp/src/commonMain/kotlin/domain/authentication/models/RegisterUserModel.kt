package domain.authentication.models

import kotlinx.serialization.Serializable

@Serializable
data class RegisterUserModel(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)