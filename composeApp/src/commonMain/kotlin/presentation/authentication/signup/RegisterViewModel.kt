@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.signup

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.text2.input.textAsFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.email_exists
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
import presentation.utils.UiText


class RegisterViewModel(
    private val userEmailPasswordValidator: UserEmailPasswordValidator,
    private val registerUserUseCase: RegisterUserUseCase
) : ViewModel() {

    var registerState by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val registrationEvent = eventChannel.receiveAsFlow()

    init {
        combine(registerState.email.textAsFlow(), registerState.password.textAsFlow()) { email, password ->
            val isValidEmail = userEmailPasswordValidator.isValidEmail(email.toString())
            val passwordValidationState = userEmailPasswordValidator.validatePassword(password.toString())

            val canRegister = isValidEmail && passwordValidationState.isValidPassword && !registerState.isRegistering

            registerState = registerState.copy(
                isValidEmail = isValidEmail,
                passwordValidationState = passwordValidationState,
                canRegister = canRegister
            )
        }.launchIn(viewModelScope)
    }

    fun onAction(registerAction: RegisterAction) {
        when(registerAction) {
            RegisterAction.OnLoginClicked -> {

            }
            RegisterAction.OnRegisterClicked -> {
                register()
            }
            RegisterAction.OnTogglePasswordVisibilityClicked -> {
                registerState = registerState.copy(
                    isPasswordVisible = !registerState.isPasswordVisible
                )
            }
        }
    }

    @OptIn(ExperimentalFoundationApi::class)
    private fun register() {
        viewModelScope.launch {
            registerState = registerState.copy(isRegistering = true)

            val result = registerUserUseCase.execute(
                RegisterUserModel(email = registerState.email.text.toString().trim(),
                password = registerState.password.text.toString()
            ))

            registerState = registerState.copy(isRegistering = false)

            when(result) {
                is CheckResult.Failure -> {
                    if(result.exceptionError == DataError.Network.CONFLICT) {
                        eventChannel.send(
                            RegisterEvent.RegistrationFailure(
                            UiText.ResourceString(resource = Res.string.email_exists)
                        ))
                    }
                    else {
                        eventChannel.send(RegisterEvent.RegistrationFailure(UiText.DynamicString(value = result.responseError ?: "")))
                    }
                }
                is CheckResult.Success -> {
                    eventChannel.send(RegisterEvent.RegistrationSuccess)
                }
            }
        }
    }
}