@file:OptIn(ExperimentalFoundationApi::class)

package presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import co.touchlab.kermit.Logger
import org.koin.compose.viewmodel.koinViewModel
import presentation.authentication.login.LoginAction
import presentation.authentication.login.LoginEvent
import presentation.authentication.login.LoginScreen
import presentation.authentication.login.LoginViewModel
import presentation.utils.ObserveAsEvents

data object LoginScreenRoute : Screen {

    @Composable
    override fun Content() {
        val loginViewModel = koinViewModel<LoginViewModel>()
        val loginState = loginViewModel.loginState
        val navigator = LocalNavigator.current

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
                        Logger.d {
                            "OnLoginFailure"
                        }
                    }
                    LoginEvent.OnLoginSuccess -> {
                        Logger.d {
                            "OnLoginSuccess"
                        }
                    }
                }
            })
    }
}