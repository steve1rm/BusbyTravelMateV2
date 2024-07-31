package domain.authentication.models

data class RegisterUserModel(
    val email: String,
    val password: String,
    val returnSecureToken: Boolean = true
)