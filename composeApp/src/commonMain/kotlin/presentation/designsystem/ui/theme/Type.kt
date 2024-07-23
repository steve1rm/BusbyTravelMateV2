package presentation.designsystem.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.poppins_bold
import busbytravelmatev2.composeapp.generated.resources.poppins_light
import busbytravelmatev2.composeapp.generated.resources.poppins_medium
import busbytravelmatev2.composeapp.generated.resources.poppins_regular
import busbytravelmatev2.composeapp.generated.resources.poppins_semibold
import org.jetbrains.compose.resources.Font

@Composable
fun Poppins(): FontFamily {
    return FontFamily(
        Font(
            resource = Res.font.poppins_light,
            weight = FontWeight.Light
        ),
        Font(
            resource = Res.font.poppins_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.poppins_medium,
            weight = FontWeight.Medium
        ),
        Font(
            resource = Res.font.poppins_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resource = Res.font.poppins_semibold,
            weight = FontWeight.SemiBold
        ))
}

@Composable
fun Typography(): Typography {
    return Typography(
        bodySmall = TextStyle(
            fontFamily = Poppins(),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            lineHeight = 20.sp,
            color = BusbyGray
        ),
        bodyMedium = TextStyle(
            fontFamily = Poppins(),
            fontWeight = FontWeight.Medium,
            fontSize = 14.sp,
            lineHeight = 22.sp,
        ),
        bodyLarge = TextStyle(
            fontFamily = Poppins(),
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = 0.4.sp
        ),
        labelLarge = TextStyle(
            fontFamily = Poppins(),
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 24.sp,
        ),
        headlineMedium = TextStyle(
            fontFamily = Poppins(),
            fontWeight = FontWeight.SemiBold,
            fontSize = 24.sp,
            color = BusbyWhite
        )
    )
}