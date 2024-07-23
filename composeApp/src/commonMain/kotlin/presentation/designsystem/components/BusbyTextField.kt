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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.TextFieldLineLimits
import androidx.compose.foundation.text2.input.TextFieldState
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import presentation.designsystem.ui.theme.CheckIcon
import presentation.designsystem.ui.theme.EmailIcon

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BusbyTextField(
    state: TextFieldState,
    startIcon: ImageVector?,
    endIcon: ImageVector?,
    hint: String,
    title: String?,
    modifier: Modifier = Modifier,
    error: String? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    additionalInfo: String? = null
) {
    var isFocused by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom
        ) {

            if(!title.isNullOrBlank()) {
                Text(text = title,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    fontSize = 20.sp)
            }

            if(!error.isNullOrBlank()) {
                Text(
                    text = error,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp)
            }
            else if(!additionalInfo.isNullOrBlank()) {
                Text(
                    text = additionalInfo,
                    color = MaterialTheme.colorScheme.error,
                    fontSize = 12.sp)
            }
        }

        Spacer(modifier = Modifier.height(4.dp))

        BasicTextField2(
            state = state,
            textStyle = LocalTextStyle.current.copy(
                color = MaterialTheme.colorScheme.onBackground
            ),
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            lineLimits = TextFieldLineLimits.SingleLine,
            cursorBrush = SolidColor(MaterialTheme.colorScheme.onBackground),
            modifier = Modifier
                .clip(RoundedCornerShape(16.dp))
                .background(
                    color = if (isFocused) {
                        MaterialTheme.colorScheme.primary.copy( alpha = 0.05f)
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
                .padding(12.dp)
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                },
            decorator = { innerBox ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    if(startIcon != null) {
                        Icon(
                            imageVector = EmailIcon,
                            contentDescription = "Email icon",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                    }

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

                    if(endIcon != null && error.isNullOrBlank()) {
                        Spacer(modifier = Modifier.width(16.dp))

                        Icon(
                            imageVector = CheckIcon,
                            contentDescription = "Check icon",
                            tint = MaterialTheme.colorScheme.onSurfaceVariant,
                            modifier = Modifier.padding(end = 8.dp)
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
fun PreviewBusbyRunnerTextField() {
    BusbyTravelMateTheme {
        BusbyTextField(
            state = rememberTextFieldState(),
            startIcon = EmailIcon,
            endIcon = CheckIcon,
            hint = "example@test.com",
            title = "Email",
            keyboardType = KeyboardType.Email,
            additionalInfo = "Must be a valid email",
            modifier = Modifier.fillMaxWidth())
    }
}