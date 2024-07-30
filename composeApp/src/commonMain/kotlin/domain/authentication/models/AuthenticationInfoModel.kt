package domain.authentication.models

data class AuthenticationInfoModel(
    val email: String = "",
    val expiresIn: String = "",
    val idToken: String = "",
    val kind: String = "",
    val localId: String = "",
    val refreshToken: String = ""
)