package domain.authentication.models

import kotlinx.serialization.Serializable

/** TODO remove the serializable and have a mapper to and from the DTO */
@Serializable
data class AuthenticationUserModel(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)