@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.touchlab.kermit.Logger
import domain.authentication.UserEmailPasswordValidator
import domain.authentication.usecases.LoginUserWithEmailAndPasswordUseCase
import domain.preferences.usecases.RetrievePreferenceUseCase
import domain.preferences.usecases.SavePreferenceUseCase
import domain.utils.CheckResult
import domain.utils.DataError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class LoginViewModel(
    private val userEmailPasswordValidator: UserEmailPasswordValidator,
    private val loginUserWithEmailAndPasswordUseCase: LoginUserWithEmailAndPasswordUseCase,
    private val savePreferenceUseCase: SavePreferenceUseCase,
    private val retrievePreferenceUseCase: RetrievePreferenceUseCase
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
            val value = retrievePreferenceUseCase.execute("ACCESS")
            Logger.d { "The ACCESS [ ${value.orEmpty()} ]" }
            savePreferenceUseCase.execute("ACCESS", "This is the token that is from data store")

            loginState = loginState.copy(isLoggingIn = true)

         /*  val result = loginUserWithEmailAndPasswordUseCase.execute(
                email = loginState.email.text.toString().trim(),
                password = loginState.password.text.toString()
            )

            loginState = loginState.copy(isLoggingIn = false)

            when(result) {
                is CheckResult.Failure -> {
                    *//** Display toast message *//*
                    if(result.exceptionError == DataError.Network.UNAUTHORIZED) {
                        eventLoginChannel.send(LoginEvent.OnLoginFailure(result.exceptionError.toString()))
                    }
                    else {
                        eventLoginChannel.send(LoginEvent.OnLoginFailure(result.exceptionError.toString()))
                    }
                }
                is CheckResult.Success -> {
                    *//** Go to home page *//*
                    eventLoginChannel.send(LoginEvent.OnLoginSuccess)
                }
            }*/
        }
    }
}