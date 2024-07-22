package presentation.designsystem.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text2.BasicSecureTextField
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.TextObfuscationMode
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.hide_password
import busbytravelmatev2.composeapp.generated.resources.show_password
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import presentation.designsystem.ui.theme.EyeClosedIcon
import presentation.designsystem.ui.theme.EyeOpenedIcon
import presentation.designsystem.ui.theme.LockIcon

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BusbyPasswordTextField(
    state: TextFieldState,
    hint: String,
    title: String?,
    modifier: Modifier = Modifier,
    isPasswordValid: Boolean = false,
    isPasswordVisible: Boolean = false,
    onTogglePasswordVisibility: () -> Unit,
) {
    var isFocused by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier,
    ) {
        if(!title.isNullOrBlank()) {
            Text(text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                fontSize = 20.sp)
        }

        Spacer(modifier = Modifier.height(4.dp))

        BasicSecureTextField(
            state = state,
            textObfuscationMode =
            if(isPasswordVisible) {
                TextObfuscationMode.Visible
            }
            else {
                TextObfuscationMode.Hidden
            },
            keyboardType = KeyboardType.Password,
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.05f)
                    } else {
                        MaterialTheme.colorScheme.surface
                    }
                )
                .border(
                    width = 1.dp,
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Transparent
                    },
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(horizontal = 12.dp)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            decorator = { innerBox ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {

                    Icon(
                        imageVector = LockIcon,
                        contentDescription = "Email icon",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.width(16.dp))

                    Box(
                        modifier = Modifier.weight(1f)
                    ) {
                        if(state.text.isBlank() && !isFocused) {
                            Text(text = hint,
                                color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.4f),
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                        innerBox()
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    IconButton(onClick = {
                        onTogglePasswordVisibility()
                    }) {
                        Icon(
                            imageVector = if (isPasswordVisible) EyeClosedIcon else EyeOpenedIcon,
                            contentDescription = if (isPasswordVisible) stringResource(resource = Res.string.show_password) else stringResource(resource = Res.string.hide_password),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier
                                .padding(end = 8.dp)
                        )
                    }
                }
            }
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview
fun PreviewBusbyRunnerPasswordTextField() {
    BusbyTravelMateTheme {
        BusbyPasswordTextField(
            state = rememberTextFieldState(),
            hint = "example@test.com",
            title = "Password",
            isPasswordVisible = false,
            onTogglePasswordVisibility = {},
            modifier = Modifier.fillMaxWidth())
    }
}