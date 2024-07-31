package data.authentication.dto

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationInfoDto(
    val email: String = "",
    val expiresIn: String = "",
    val idToken: String = "",
    val kind: String = "",
    val localId: String = "",
    val refreshToken: String = ""
)