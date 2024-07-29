package domain.authentication.imp

import domain.authentication.PatternValidator
import domain.utils.EmailValidator

class EmailPatternValidatorImp(
    private val emailValidator: EmailValidator
) : PatternValidator {

    override fun matches(value: String): Boolean {
        return emailValidator.isValid(value)
    }
}
