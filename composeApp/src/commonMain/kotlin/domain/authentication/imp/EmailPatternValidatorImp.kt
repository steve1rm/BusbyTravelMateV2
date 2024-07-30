package domain.authentication.imp

import com.chrynan.validator.EmailValidator
import com.chrynan.validator.isValid
import domain.authentication.PatternValidator

class EmailPatternValidatorImp(
    private val emailValidator: EmailValidator
) : PatternValidator {

    override fun matches(value: String): Boolean {
        return emailValidator.validate(value).isValid
    }
}