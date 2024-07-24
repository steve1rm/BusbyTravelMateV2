package presentation.authentication.signup

import presentation.utils.UiText


sealed interface RegisterEvent {
    data object RegistrationSuccess : RegisterEvent
    data class RegistrationFailure(val error: UiText) : RegisterEvent
}
