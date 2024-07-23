package presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun isBlurSupported(): Boolean {
    return true
}

@Composable
actual fun getScreenWidthDp(): Dp {
    val screenWidthPx = js("window.innerWidth") as Int
    val density = js("window.devicePixelRatio") as Float
    val screenWidthDp = screenWidthPx / density

    return screenWidthDp.dp
}

@Composable
actual fun getScreenHeightDp(): Dp {
    // Using JavaScript interop to get the screen height
    val screenHeightPx = js("window.innerHeight") as Int
    val density = js("window.devicePixelRatio") as Float
    val screenHeightDp = screenHeightPx / density

    return screenHeightDp.dp
}

@Composable
actual fun screenWidthPx(): Int {
    TODO()
}

@Composable
actual fun screenHeightPx(): Int {
    TODO("Not yet implemented")
}

@Composable
actual fun smallestDimensionDp(): Dp {
    TODO("Not yet implemented")
}