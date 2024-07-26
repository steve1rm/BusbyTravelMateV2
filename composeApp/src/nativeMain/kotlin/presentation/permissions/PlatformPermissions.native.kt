package presentation.permissions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import dev.icerock.moko.permissions.compose.BindEffect

actual class PermissionsControllerFactory {
    @Composable
    actual fun createPermissionsController(): PermissionsController {
        val factory = rememberPermissionsControllerFactory()
        val controller = remember(factory) {
            factory.createPermissionsController()
        }

        BindEffect(controller)

        return PermissionsController(controller)
    }
}

actual class PermissionsController(private val controller: dev.icerock.moko.permissions.PermissionsController) {
    actual suspend fun getPermissionState(permission: Permission): PermissionState {
        val result = when(controller.isPermissionGranted(dev.icerock.moko.permissions.Permission.REMOTE_NOTIFICATION)) {
            true -> PermissionState.Granted
            false -> PermissionState.Denied
        }

        return result

    }

    actual suspend fun providePermission(permission: Permission) {
        try {
            controller.providePermission(dev.icerock.moko.permissions.Permission.REMOTE_NOTIFICATION)
        } catch (e: DeniedAlwaysException) {
            throw DeniedAlwaysException()
        } catch (e: DeniedException) {
            throw DeniedException()
        } catch (e: RequestCanceledException) {
            throw RequestCanceledException()
        }
    }

    actual  fun openAppSettings() {
        controller.openAppSettings()
    }
}