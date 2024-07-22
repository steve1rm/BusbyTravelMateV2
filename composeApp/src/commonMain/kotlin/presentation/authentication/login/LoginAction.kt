package presentation.authentication.login

sealed interface LoginAction {
    data object OnTogglePasswordVisibility : LoginAction
    data object OnLoginClicked : LoginAction
    data object OnSignUpClicked : LoginAction
}