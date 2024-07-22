@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.TextFieldState

data class LoginState(
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState(),
    val isPasswordVisible: Boolean = false,
    val isValidEmail: Boolean = false,
    val canLogin: Boolean = false,
    val isLoggingIn: Boolean = false
)
