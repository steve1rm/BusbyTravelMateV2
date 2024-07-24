@file:OptIn(ExperimentalFoundationApi::class)

package presentation.authentication.signup

import androidx.compose.foundation.ExperimentalFoundationApi
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.contain_number
import busbytravelmatev2.composeapp.generated.resources.create_account
import busbytravelmatev2.composeapp.generated.resources.email
import busbytravelmatev2.composeapp.generated.resources.example_email
import busbytravelmatev2.composeapp.generated.resources.existing_account
import busbytravelmatev2.composeapp.generated.resources.login
import busbytravelmatev2.composeapp.generated.resources.lower_case_character
import busbytravelmatev2.composeapp.generated.resources.must_be_valid_email
import busbytravelmatev2.composeapp.generated.resources.password
import busbytravelmatev2.composeapp.generated.resources.password_length
import busbytravelmatev2.composeapp.generated.resources.register
import busbytravelmatev2.composeapp.generated.resources.upper_case_character
import domain.authentication.imp.UserEmailPasswordValidatorImp
import domain.authentication.PasswordValidationState
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.components.BusbyActionButton
import presentation.designsystem.components.BusbyPasswordTextField
import presentation.designsystem.components.BusbyTextField
import presentation.designsystem.components.GradientBackground
import presentation.designsystem.components.PasswordRequirement
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import presentation.designsystem.ui.theme.CheckIcon
import presentation.designsystem.ui.theme.EmailIcon
import presentation.designsystem.ui.theme.Poppins

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun RegisterScreen(
    registerState: RegisterState,
    onAction: (RegisterAction) -> Unit
) {
    GradientBackground(
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 32.dp)
                    .padding(top = 16.dp)
            ) {
                Text(
                    text = stringResource(resource = Res.string.create_account),
                    style = MaterialTheme.typography.headlineMedium)

                val annotatedString = buildDescriptionAnnotatedString()
                ClickableText(text = annotatedString) { offSet ->
                    annotatedString.getStringAnnotations(
                        tag = "clickable_text",
                        start = offSet,
                        end = offSet
                    ).firstOrNull()?.let {
                        onAction(RegisterAction.OnLoginClicked)
                    }
                }

                Spacer(modifier = Modifier.height(48.dp))

                BusbyTextField(
                    state = registerState.email,
                    startIcon = EmailIcon,
                    endIcon = if(registerState.isValidEmail) CheckIcon else null,
                    hint = stringResource(resource = Res.string.example_email),
                    title = stringResource(resource = Res.string.email),
                    modifier = Modifier.fillMaxWidth(),
                    additionalInfo = stringResource(resource = Res.string.must_be_valid_email),
                    keyboardType = KeyboardType.Email
                )

                Spacer(modifier = Modifier.height(16.dp))

                BusbyPasswordTextField(
                    state = registerState.password,
                    isPasswordVisible = registerState.isPasswordVisible,
                    hint = stringResource(resource = Res.string.password),
                    title = stringResource(resource = Res.string.password),
                    modifier = Modifier.fillMaxWidth(),
                    onTogglePasswordVisibility = {
                        onAction(RegisterAction.OnTogglePasswordVisibilityClicked)
                    }
                )

                Spacer(modifier = Modifier.height(16.dp))

                PasswordRequirement(
                    isValid = registerState.passwordValidationState.hasMinLength,
                    text = stringResource(resource = Res.string.password_length, UserEmailPasswordValidatorImp.MIN_PASSWORD_LENGTH),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

                PasswordRequirement(
                    isValid = registerState.passwordValidationState.hasNumber,
                    text = stringResource(resource = Res.string.contain_number),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(4.dp))

                PasswordRequirement(
                    isValid = registerState.passwordValidationState.hasLowerCaseCharacter,
                    text = stringResource(resource = Res.string.lower_case_character),
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(4.dp))

                PasswordRequirement(
                    isValid = registerState.passwordValidationState.hasUpperCaseCharacter,
                    text = stringResource(resource = Res.string.upper_case_character),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(32.dp))

                BusbyActionButton(
                    text = stringResource(resource = Res.string.register),
                    isLoading = registerState.isRegistering,
                    isEnabled = registerState.canRegister || !registerState.isRegistering,
                    modifier = Modifier.fillMaxWidth(),
                    onClicked = {
                        onAction(RegisterAction.OnRegisterClicked)
                    }
                )
            }
        }
    )
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
            this.append(stringResource(resource = Res.string.existing_account))
            this.append(" ")
        }

        this.pushStringAnnotation(
            tag = "clickable_text",
            annotation = stringResource(resource = Res.string.login),
        )

        this.withStyle(
            SpanStyle(
                fontFamily = Poppins(),
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            this.append(text = stringResource(resource = Res.string.login))
        }
        pop()
    }
    return annotatedString
}

@Composable
@Preview
fun PreviewRegisterScreen() {
    BusbyTravelMateTheme {
        RegisterScreen(
            registerState = RegisterState(
                passwordValidationState = PasswordValidationState(
                    true, true, true, true)
            ),
            onAction = {} )
    }
}