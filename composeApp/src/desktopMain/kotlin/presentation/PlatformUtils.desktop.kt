package presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import java.awt.Toolkit

actual fun isBlurSupported(): Boolean {
    return true
}

@Composable
actual fun getScreenWidthDp(): Dp {
    val screenWidth = Toolkit.getDefaultToolkit().screenSize.width

    return screenWidth.dp
}

@Composable
actual fun getScreenHeightDp(): Dp {
    val screenHeight = Toolkit.getDefaultToolkit().screenSize.height

    return screenHeight.dp
}

@Composable
actual fun screenWidthPx(): Int {
    val screenSize = Toolkit.getDefaultToolkit().screenSize

    return screenSize.width
}

@Composable
actual fun screenHeightPx(): Int {
    val screenSize = Toolkit.getDefaultToolkit().screenSize

    return screenSize.height
}

@Composable
actual fun smallestDimensionDp(): Dp {
    return minOf(
        getScreenWidthDp(),
        getScreenHeightDp()
    )
}