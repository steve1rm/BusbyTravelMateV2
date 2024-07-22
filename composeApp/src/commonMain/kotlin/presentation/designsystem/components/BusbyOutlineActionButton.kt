package presentation.designsystem.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.sign_up
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyTravelMateTheme

@Composable
fun BusbyRunnerOutlineActionButton(
    text: String,
    isLoading: Boolean,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    onClicked: () -> Unit
) {
    OutlinedButton(
        modifier = modifier
            .height(IntrinsicSize.Min),
        /** Sets the height to the minimum height of one of its children */ /** Sets the height to the minimum height of one of its children */
        enabled = isEnabled,
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = MaterialTheme.colorScheme.onBackground,
        ),
        shape = CircleShape.copy(CornerSize(100f)),
        onClick = {
            onClicked()
        }) {

        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
            contentAlignment = Alignment.Center) {

            /** Using alpha to hide or show, which is the same as invisible or visible,
             *  so will retain the height of the button */
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
fun PreviewBusbyRunnerOutlineActionButton() {
    BusbyTravelMateTheme {
        BusbyRunnerOutlineActionButton(
            text = stringResource(resource = Res.string.sign_up),
            isLoading = false) {
        }
    }
}
