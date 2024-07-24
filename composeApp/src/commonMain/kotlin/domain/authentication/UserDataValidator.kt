package domain.authentication

interface UserDataValidator {

    fun isValidEmail(email: String): Boolean

    fun validatePassword(password: String): PasswordValidationState
}