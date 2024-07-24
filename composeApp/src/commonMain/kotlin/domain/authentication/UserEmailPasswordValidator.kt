package domain.authentication

interface UserEmailPasswordValidator {

    fun isValidEmail(email: String): Boolean

    fun validatePassword(password: String): PasswordValidationState
}