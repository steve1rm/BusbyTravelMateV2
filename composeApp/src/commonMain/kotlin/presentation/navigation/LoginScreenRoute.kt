@file:OptIn(KoinExperimentalAPI::class)

package presentation.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import co.touchlab.kermit.Logger
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.annotation.KoinExperimentalAPI
import presentation.authentication.login.LoginAction
import presentation.authentication.login.LoginEvent
import presentation.authentication.login.LoginScreen
import presentation.authentication.login.LoginViewModel
import presentation.designsystem.components.Duration
import presentation.designsystem.components.ShowMessageManager
import presentation.utils.ObserveAsEvents
import presentation.utils.UiText

data object LoginScreenRoute : Screen {

    @Composable
    override fun Content() {
        val loginViewModel = koinViewModel<LoginViewModel>()
        val loginState = loginViewModel.loginState
        val navigator = LocalNavigator.current
        val showMessageManager = koinInject<ShowMessageManager>()

        LoginScreen(
            loginState = loginState,
            onLoginAction = { loginAction ->
                when(loginAction) {
                    LoginAction.OnSignUpClicked -> {
                        navigator?.push(item = RegisterScreenRoot)
                    }
                    else -> {
                        loginViewModel.onLoginAction(loginAction)
                    }
                }
            }
        )

        ObserveAsEvents(
            flow = loginViewModel.loginEvent,
            onEvent = { loginEvent ->
                when(loginEvent) {
                    is LoginEvent.OnLoginFailure -> {
                        // Display a toast message
                        val message = UiText.DynamicString(loginEvent.error.toString())

                        showMessageManager.showMessage(loginEvent.error.toString(), Duration.LONG_DURATION)
                        Logger.d {
                            "OnLoginFailure"
                        }
                    }
                    LoginEvent.OnLoginSuccess -> {
                        // Go to the home or list hotel page
                        // Not implemented navigator?.push(item = HotelListScreen)
                        Logger.d {
                            "OnLoginSuccess"
                        }
                    }
                }
            })
    }
}