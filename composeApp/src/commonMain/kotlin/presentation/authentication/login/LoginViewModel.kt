@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import domain.authentication.UserEmailPasswordValidator
import domain.authentication.models.RegisterUserModel
import domain.authentication.usecases.RegisterUserUseCase
import domain.utils.CheckResult
import domain.utils.DataError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userEmailPasswordValidator: UserEmailPasswordValidator,
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    var loginState by mutableStateOf(LoginState())
        private set

    private val eventLoginChannel = Channel<LoginEvent>()
    val loginEvent = eventLoginChannel.receiveAsFlow()

    init {
        combine(loginState.email.textAsFlow(), loginState.password.textAsFlow()) { email, password ->
            val isValidEmail = userEmailPasswordValidator.isValidEmail(email = email.toString().trim())

            loginState = loginState.copy(
                isValidEmail = isValidEmail,
                canLogin = isValidEmail && password.isNotEmpty()) /** using notEmpty as a 'space' could be a valid password character */
        }.launchIn(viewModelScope)
    }

    fun onLoginAction(action: LoginAction) {
        when(action) {
            LoginAction.OnLoginClicked -> {
                login()
            }

            LoginAction.OnTogglePasswordVisibility -> {
                loginState = loginState.copy(
                    isPasswordVisible = !loginState.isPasswordVisible
                )
            }

            LoginAction.OnSignUpClicked -> {
                viewModelScope.launch {
                //    eventLoginChannel.send(LoginEvent.OnSignUpClicked)
                }
            }
        }
    }

    private fun login() {
        viewModelScope.launch {
            loginState = loginState.copy(isLoggingIn = true)

            val result = registerUserUseCase.execute(
                RegisterUserModel( email = loginState.email.text.toString().trim(),
                    password = loginState.password.text.toString()
                ))

            loginState = loginState.copy(isLoggingIn = false)

            when(result) {
                is CheckResult.Failure -> {
                    /** Display toast message */
                    if(result.exceptionError == DataError.Network.UNAUTHORIZED) {
                        eventLoginChannel.send(LoginEvent.OnLoginFailure(result.exceptionError.toString()))
                    }
                    else {
                        eventLoginChannel.send(LoginEvent.OnLoginFailure(result.exceptionError.toString()))
                    }
                }
                is CheckResult.Success -> {
                    /** Go to home page */
                    eventLoginChannel.send(LoginEvent.OnLoginSuccess)
                }
            }
        }
    }
}