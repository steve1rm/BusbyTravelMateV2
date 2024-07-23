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
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalDensity
import org.jetbrains.compose.ui.tooling.preview.Preview
import presentation.designsystem.ui.theme.BusbyTravelMateTheme
import presentation.isBlurSupported
import presentation.screenWidthPx
import presentation.smallestDimensionDp

@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    hasToolbar: Boolean = true,
    content: @Composable ColumnScope.() -> Unit
) {
    val density = LocalDensity.current

    val screenWidthPx = screenWidthPx()
    val smallestDimensionDp = smallestDimensionDp()
    val smallestDimensionPx = with(density) {
        smallestDimensionDp.roundToPx()
    }

    val primaryColor = MaterialTheme.colorScheme.primary
    val shouldAddBlurEffect = isBlurSupported()


    Box(modifier = modifier
        .fillMaxSize()
        .background(MaterialTheme.colorScheme.background)) {

        Box(modifier = modifier
            .fillMaxSize()
            .then(
                if (shouldAddBlurEffect) {
                    Modifier.blur(smallestDimensionDp / 3f)
                } else {
                    Modifier
                }
            )
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        if (shouldAddBlurEffect) primaryColor else primaryColor.copy(
                            alpha = 0.3f
                        ), MaterialTheme.colorScheme.background
                    ),
                    center = Offset(
                        x = screenWidthPx / 2f,
                        y = -100f
                    ),
                    radius = smallestDimensionPx / 2f
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