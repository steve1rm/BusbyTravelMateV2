package presentation.designsystem.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val DarkColorScheme = darkColorScheme(
    primary = BusbyGreen,
    background = BusbyBlack,
    surface = BusbyDarkGray,
    secondary = BusbyWhite,
    tertiary = BusbyWhite,
    primaryContainer = BusbyGreen30,
    onPrimary = BusbyBlack,
    onBackground = BusbyWhite,
    onSurface = BusbyWhite,
    onSurfaceVariant = BusbyGray,
    error = BusbyDarkRed
)

val LightColorScheme = lightColorScheme(
    primary = BusbyGreenLight,
    background = BusbyBlackLight,
    surface = BusbyDarkGrayLight,
    secondary = BusbyWhiteLight,
    tertiary = BusbyWhiteLight,
    primaryContainer = BusbyGreen30Light,
    onPrimary = BusbyBlackLight,
    onBackground = BusbyWhiteLight,
    onSurface = BusbyWhiteLight,
    onSurfaceVariant = BusbyGrayLight,
    error = BusbyDarkRed
)

@Composable
fun BusbyTravelMateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    // TODO MAYBE GET DYNAMIC COLORS WORKING FOR COMPOSE KMM
    /* val colorScheme = when {
         dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
             val context = LocalContext.current
             if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
         }

         darkTheme -> DarkColorScheme
         else -> LightColorScheme
     }*/

    val colorScheme = if(darkTheme) DarkColorScheme else LightColorScheme

  /*  val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = false
        }
    }*/

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography(),
        content = content
    )
}