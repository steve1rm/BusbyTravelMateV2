package data.authentication.dto


data class AuthenticationInfoDto(
    val email: String = "",
    val expiresIn: String = "",
    val idToken: String = "",
    val kind: String = "",
    val localId: String = "",
    val refreshToken: String = ""
)