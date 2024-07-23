package presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp

expect fun isBlurSupported(): Boolean

@Composable
expect fun getScreenWidthDp(): Dp

@Composable
expect fun getScreenHeightDp(): Dp

@Composable
expect fun screenWidthPx(): Int

@Composable
expect fun screenHeightPx(): Int

@Composable
expect fun smallestDimensionDp(): Dp
