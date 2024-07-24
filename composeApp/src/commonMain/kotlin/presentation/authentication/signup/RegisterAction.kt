package presentation.authentication.signup

sealed interface RegisterAction {
    data object OnTogglePasswordVisibilityClicked : RegisterAction
    data object OnRegisterClicked : RegisterAction
    data object OnLoginClicked : RegisterAction
}