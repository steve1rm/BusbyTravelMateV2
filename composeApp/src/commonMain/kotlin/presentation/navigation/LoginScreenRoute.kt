@file:OptIn(ExperimentalFoundationApi::class)

package presentation.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import presentation.authentication.login.LoginScreen
import presentation.authentication.login.LoginState

data object LoginScreenRoute : Screen {

    @Composable
    override fun Content() {
        LoginScreen(
            loginState = LoginState(),
            onLoginAction = {}
        )
    }
}