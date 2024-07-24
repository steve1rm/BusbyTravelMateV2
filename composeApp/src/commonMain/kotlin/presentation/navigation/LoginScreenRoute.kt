@file:OptIn(ExperimentalFoundationApi::class)

package presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import co.touchlab.kermit.Logger
import org.koin.compose.viewmodel.koinViewModel
import presentation.authentication.login.LoginEvent
import presentation.authentication.login.LoginScreen
import presentation.authentication.login.LoginState
import presentation.authentication.login.LoginViewModel
import presentation.utils.ObserveAsEvents

data object LoginScreenRoute : Screen {

    @Composable
    override fun Content() {
        val loginViewModel = koinViewModel<LoginViewModel>()

        LoginScreen(
            loginState = LoginState(),
            onLoginAction = {}
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