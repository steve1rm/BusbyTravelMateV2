package presentation.designsystem.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyBlack
import presentation.designsystem.ui.theme.BusbyGray
import presentation.designsystem.ui.theme.BusbyTravelMateTheme

@Composable
fun BusbyActionButton(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClicked: () -> Unit
) {
    Button(
        modifier = modifier
            .height(IntrinsicSize.Min), /** Sets the height to the minimum height of one of its children */
        enabled = isEnabled,
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary,
            disabledContainerColor = BusbyGray,
            disabledContentColor = BusbyBlack
        ),
        border = BorderStroke(width = 0.6.dp, color = MaterialTheme.colorScheme.onBackground),
        shape = RoundedCornerShape(100f),
        onClick = {
            onClicked()
        }) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center) {

            /** Using alpha to hide or show, which is the same as invisible or visible,
             *  so will retain the height of the button */
            CircularProgressIndicator(
                modifier = Modifier
                    .size(16.dp)
                    .alpha(if (isLoading) 1f else 0f),
                strokeWidth = 1.6.dp,
                color = MaterialTheme.colorScheme.onPrimary
            )
            Text(
                modifier = Modifier.alpha(if(isLoading) 0f else 1f),
                text = text,
                fontWeight = FontWeight.Medium
            )
        }
    }
}

@Composable
@Preview
fun PreviewBusbyRunnerActionButton() {
    BusbyTravelMateTheme {
        BusbyActionButton(
            text = "Sign in",
            isLoading = false,
            isEnabled = true) {
        }
    }
}
