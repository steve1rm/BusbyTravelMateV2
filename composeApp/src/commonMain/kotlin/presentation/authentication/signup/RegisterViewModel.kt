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
import domain.authentication.AuthenticationRepository
import domain.authentication.Imp.UserDataValidatorImp
import domain.utils.CheckResult
import domain.utils.DataError
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import presentation.utils.UiText


class RegisterViewModel(
    private val userDataValidator: UserDataValidatorImp,
    private val authenticationRepository: AuthenticationRepository
) : ViewModel() {

    var registerState by mutableStateOf(RegisterState())
        private set

    private val eventChannel = Channel<RegisterEvent>()
    val registrationEvent = eventChannel.receiveAsFlow()

    init {
        registerState.email.textAsFlow()
            .onEach { email ->
                val isValidEmail = userDataValidator.isValidEmail(email.toString())
                val canRegister = isValidEmail && registerState.passwordValidationState.isValidPassword && !registerState.isRegistering

                registerState = registerState.copy(
                    isValidEmail = isValidEmail,
                    canRegister = canRegister
                )
            }
            .launchIn(viewModelScope)

        registerState.password.textAsFlow()
            .onEach { password ->
                val passwordValidationState = userDataValidator.validatePassword(password.toString())
                val canRegister = registerState.isValidEmail && passwordValidationState.isValidPassword && !registerState.isRegistering

                registerState = registerState.copy(
                    passwordValidationState = passwordValidationState,
                    canRegister = canRegister
                )
            }
            .launchIn(viewModelScope)
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

            val result = authenticationRepository.register(
                registerState.email.text.toString().trim(),
                registerState.password.text.toString()
            )

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