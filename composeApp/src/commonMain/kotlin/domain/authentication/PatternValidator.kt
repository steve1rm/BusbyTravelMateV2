package domain.authentication

interface PatternValidator {
    fun matches(value: String): Boolean
}