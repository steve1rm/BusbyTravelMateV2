package presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual fun isBlurSupported(): Boolean {
    return true
}

@Composable
actual fun getScreenWidthDp(): Dp {
   /* val screenWidthPx = js("window.innerWidth") as Int
    val density = js("window.devicePixelRatio") as Float
    val screenWidthDp = screenWidthPx / density

    return screenWidthDp.dp*/
    return 300.dp
}

@Composable
actual fun getScreenHeightDp(): Dp {
    // Using JavaScript interop to get the screen height
   /* val screenHeightPx = js("window.innerHeight") as Int
    val density = js("window.devicePixelRatio") as Float
    val screenHeightDp = screenHeightPx / density

    return screenHeightDp.dp*/
    return 300.dp
}

@Composable
actual fun screenWidthPx(): Int {
   return 300
}

@Composable
actual fun screenHeightPx(): Int {
    return 400
}

@Composable
actual fun smallestDimensionDp(): Dp {
    return 200.dp
}