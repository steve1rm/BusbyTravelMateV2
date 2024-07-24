package domain.authentication.imp

import domain.authentication.PasswordValidationState
import domain.authentication.PatternValidator
import domain.authentication.UserEmailPasswordValidator

class UserEmailPasswordValidatorImp(
    private val patternValidator: PatternValidator
) : UserEmailPasswordValidator {

    companion object {
        const val MIN_PASSWORD_LENGTH = 9
    }

    override fun isValidEmail(email: String): Boolean {
        return patternValidator.matches(email.trim())
    }

    override fun validatePassword(password: String): PasswordValidationState {
        val isMinLength = password.length >= MIN_PASSWORD_LENGTH
        val hasNumber = password.any { it.isDigit() }
        val hasLowerCaseCharacter = password.any { it.isLowerCase() }
        val hasUpperCaseCharacter = password.any { it.isUpperCase() }

        return PasswordValidationState(
            hasMinLength = isMinLength,
            hasNumber = hasNumber,
            hasLowerCaseCharacter = hasLowerCaseCharacter,
            hasUpperCaseCharacter = hasUpperCaseCharacter)
    }
}
