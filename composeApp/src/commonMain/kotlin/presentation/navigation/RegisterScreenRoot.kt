package presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import cafe.adriel.voyager.core.screen.Screen
import org.koin.compose.viewmodel.koinViewModel
import presentation.authentication.signup.RegisterAction
import presentation.authentication.signup.RegisterEvent
import presentation.authentication.signup.RegisterScreen
import presentation.authentication.signup.RegisterViewModel
import presentation.utils.ObserveAsEvents


data object RegisterScreenRoot : Screen {

    @Composable
    override fun Content() {
     //   val context = LocalContext.current
        val keyboardController = LocalSoftwareKeyboardController.current
        val registerViewModel = koinViewModel<RegisterViewModel>()

        ObserveAsEvents(flow = registerViewModel.registrationEvent) { registerEvent ->
            when(registerEvent) {
                is RegisterEvent.RegistrationFailure -> {
                    keyboardController?.hide()
                    //     Toast.makeText(context, registerEvent.error.asString(context), Toast.LENGTH_LONG).show()
                }
                RegisterEvent.RegistrationSuccess -> {
                    keyboardController?.hide()
                    //    Toast.makeText(context, R.string.registration_success, Toast.LENGTH_LONG).show()
              //      onSuccessfulSignUp()
                }
            }
        }


        RegisterScreen(
            registerState = registerViewModel.registerState,
            onAction = { registerAction ->
                when(registerAction) {
                    RegisterAction.OnLoginClicked -> {
                  //      onSignUpClicked()
                    }
                    else -> {
                        registerViewModel.onAction(registerAction)
                    }
                }
            })
    }

}