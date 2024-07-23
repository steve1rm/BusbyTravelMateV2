package presentation

import android.os.Build
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun isBlurSupported(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.S
}

@Composable
actual fun getScreenWidthDp(): Dp {
    val configuration = LocalConfiguration.current

    return configuration.screenWidthDp.dp
}

@Composable
actual fun screenWidthPx(): Int {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    return with(density) {
        configuration.screenWidthDp.dp.roundToPx()
    }
}

@Composable
actual fun getScreenHeightDp(): Dp {
    val configuration = LocalConfiguration.current

    return configuration.screenHeightDp.dp
}

@Composable
actual fun screenHeightPx(): Int {
    val configuration = LocalConfiguration.current
    val density = LocalDensity.current

    return with(density) {
        configuration.screenHeightDp.dp.roundToPx()
    }
}

@Composable
actual fun smallestDimensionDp(): Dp {
    return minOf(
        getScreenWidthDp(),
        getScreenHeightDp()
    )
}