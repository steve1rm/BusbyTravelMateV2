package presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

actual fun isBlurSupported(): Boolean {
    true
}

@Composable
actual fun getScreenWidthDp(): Dp {
    val screenHeight = UIScreen.mainScreen.bounds.size.height

    return screenHeight.dp
}

@Composable
actual fun getScreenHeightDp(): Dp {
    val screenWidth = UIScreen.mainScreen.bounds.size.width

    return screenWidth.dp
}

@Composable
actual fun screenWidthPx(): Int {
    return UIScreen.mainScreen.bounds.size.width.toInt()
}

@Composable
actual fun screenHeightPx(): Int {
    return UIScreen.mainScreen.bounds.size.height.toInt()
}

@Composable
actual fun smallestDimensionDp(): Dp {
    return minOf(
        getScreenWidthDp(),
        getScreenHeightDp()
    )
}