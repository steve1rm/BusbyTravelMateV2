package presentation.designsystem.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import busbytravelmatev2.composeapp.generated.resources.Res
import busbytravelmatev2.composeapp.generated.resources.analytics
import busbytravelmatev2.composeapp.generated.resources.arrow_left
import busbytravelmatev2.composeapp.generated.resources.arrow_right
import busbytravelmatev2.composeapp.generated.resources.calendar
import busbytravelmatev2.composeapp.generated.resources.check
import busbytravelmatev2.composeapp.generated.resources.cross
import busbytravelmatev2.composeapp.generated.resources.danger
import busbytravelmatev2.composeapp.generated.resources.email
import busbytravelmatev2.composeapp.generated.resources.eye_closed
import busbytravelmatev2.composeapp.generated.resources.eye_opened
import busbytravelmatev2.composeapp.generated.resources.finish
import busbytravelmatev2.composeapp.generated.resources.keyboard_arrow_down
import busbytravelmatev2.composeapp.generated.resources.keyboard_arrow_up
import busbytravelmatev2.composeapp.generated.resources.location
import busbytravelmatev2.composeapp.generated.resources.lock
import busbytravelmatev2.composeapp.generated.resources.logo
import busbytravelmatev2.composeapp.generated.resources.logout
import busbytravelmatev2.composeapp.generated.resources.pause
import busbytravelmatev2.composeapp.generated.resources.person
import busbytravelmatev2.composeapp.generated.resources.run
import busbytravelmatev2.composeapp.generated.resources.run_outlined
import busbytravelmatev2.composeapp.generated.resources.start
import busbytravelmatev2.composeapp.generated.resources.stop
import org.jetbrains.compose.resources.painterResource

val AnalyticIcon: Painter
    @Composable
    get() {
        return painterResource(resource = Res.drawable.analytics)
    }


val EmailIcon: Painter
    @Composable
    get() = painterResource(resource = Res.drawable.email)

/*
val ArrowLeftIcon: Painter
    @Composable
    get() = painterResource(resource = Res.drawable.arrow_left)

val ArrowRightIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.arrow_right)

val CalendarIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.calendar)

val CheckIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.check)

val CrossIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.cross)

val ExclamationMarkIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.danger)

val EyeClosedIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.eye_closed)

val EyeOpenedIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.eye_opened)

val FinishIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.finish)

val KeyboardArrowDownIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.keyboard_arrow_down)

val KeyboardArrowUpIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.keyboard_arrow_up)

val LocationIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.location)

val LockIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.lock)

val LogoIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.logo)

val LogoutIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.logout)

val PauseIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.pause)

val PersonIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.person)

val RunOutlinedIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.run_outlined)

val RunIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.run)

val StartIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.start)

val StopIcon: ImageVector
    @Composable
    get() = ImageVector.vectorResource(id = Res.drawable.stop)*/
