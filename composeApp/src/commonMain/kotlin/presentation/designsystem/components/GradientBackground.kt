package presentation.designsystem.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyTravelMateTheme

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    hasToolbar: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
 //   val configuration = LocalConfiguration.current
    val density = LocalDensity.current

   /* val screenWidthPx = with(density) {
        configuration.screenWidthDp.dp.roundToPx()
    }

    val smallestDimensionDp = minOf(
        configuration.screenWidthDp.dp,
        configuration.screenHeightDp.dp
    )*/

  /*  val smallestDimensionPx = with(density) {
        smallestDimensionDp.roundToPx()
    }*/

    val primaryColor = MaterialTheme.colorScheme.primary
    val shouldAddBlurEffect = true //Build.VERSION.SDK_INT >= Build.VERSION_CODES.S


    Box(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {

        Box(modifier = modifier
            .fillMaxSize()
            .then(
             /*   if (shouldAddBlurEffect) {
                    Modifier.blur(smallestDimensionDp / 3f)
                } else {*/
                    Modifier
             //   }
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        if (shouldAddBlurEffect) primaryColor else primaryColor.copy(
                            alpha = 0.3f
                        ), MaterialTheme.colorScheme.background
                    ),
/*                    center = Offset(
                        x = screenWidthPx / 2f,
                        y = -100f
                    ),
                    radius = smallestDimensionPx / 2f*/
                ),
            ))

        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(
                    if(hasToolbar) {
                        Modifier
                    }
                    else {
                        Modifier.systemBarsPadding()
                    }
                )
        ) {
            content()
        }
    }
}

@Composable
// @PreviewScreenSizes
@Preview
fun PreviewGradientBackground() {
    BusbyTravelMateTheme {
        GradientBackground(
            modifier = Modifier,
            hasToolbar = true
        ) {

        }
    }
}