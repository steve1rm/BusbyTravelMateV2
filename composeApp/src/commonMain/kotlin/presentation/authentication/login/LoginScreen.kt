@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.login

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.dont_have_account
import busbytravelmatev2.composeapp.generated.resources.email
import busbytravelmatev2.composeapp.generated.resources.example_email
import busbytravelmatev2.composeapp.generated.resources.login
import busbytravelmatev2.composeapp.generated.resources.login_welcome
import busbytravelmatev2.composeapp.generated.resources.password
import busbytravelmatev2.composeapp.generated.resources.sign_up
import busbytravelmatev2.composeapp.generated.resources.welcome_message
import presentation.designsystem.ui.theme.Poppins
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.components.BusbyActionButton
import presentation.designsystem.components.BusbyPasswordTextField
import presentation.designsystem.components.BusbyTextField
import presentation.designsystem.components.GradientBackground
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import presentation.designsystem.ui.theme.CheckIcon
import presentation.designsystem.ui.theme.EmailIcon

@Composable
fun LoginScreen(
    loginState: LoginState,
    modifier: Modifier = Modifier,
    onLoginAction: (LoginAction) -> Unit
) {
    GradientBackground {
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .padding(vertical = 32.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = stringResource(resource = Res.string.login_welcome),
                fontWeight = FontWeight.SemiBold,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Text(
                text = stringResource(resource = Res.string.welcome_message),
                fontSize = 12.sp,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(48.dp))

            BusbyTextField(
                state = loginState.email,
                startIcon = EmailIcon,
                endIcon = if(loginState.isValidEmail) CheckIcon else null,
                hint = stringResource(resource = Res.string.example_email),
                title = stringResource(resource = Res.string.email),
                keyboardType = KeyboardType.Email,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            BusbyPasswordTextField(
                state = loginState.password,
                hint = stringResource(resource = Res.string.password),
                title = stringResource(resource = Res.string.password),
                modifier = Modifier.fillMaxWidth(),
                isPasswordVisible = loginState.isPasswordVisible,
                onTogglePasswordVisibility = {
                    onLoginAction(LoginAction.OnTogglePasswordVisibility)
                }
            )

            Spacer(modifier = Modifier.height(32.dp))

            BusbyActionButton(
                text = stringResource(resource = Res.string.login),
                isLoading = loginState.isLoggingIn,
                isEnabled = loginState.canLogin && !loginState.isLoggingIn,
                onClicked = {
                    onLoginAction(LoginAction.OnLoginClicked)
                }
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 32.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            val annotatedString = buildDescriptionAnnotatedString()

            ClickableText(text = annotatedString) { offSet ->
                annotatedString.getStringAnnotations(
                    tag = "clickable_text",
                    start = offSet,
                    end = offSet
                ).firstOrNull()?.let {
                    onLoginAction(LoginAction.OnSignUpClicked)
                }
            }
        }
    }
}

@Composable
private fun buildDescriptionAnnotatedString(): AnnotatedString {
    val annotatedString = buildAnnotatedString {
        this.withStyle(
            SpanStyle(
                fontFamily = Poppins(),
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        ) {
            this.append(stringResource(resource = Res.string.dont_have_account))
            this.append(" ")
        }

        this.pushStringAnnotation(
            tag = "clickable_text",
            annotation = stringResource(resource = Res.string.sign_up),
        )

        this.withStyle(
            SpanStyle(
                fontFamily = Poppins(),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            this.append(text = stringResource(resource = Res.string.sign_up))
        }
        pop()
    }
    return annotatedString
}

@Composable
@Preview
fun PreviewLoginScreen() {
    BusbyTravelMateTheme {
        LoginScreen(
            loginState = LoginState(),
            onLoginAction = {}
        )
    }
}

