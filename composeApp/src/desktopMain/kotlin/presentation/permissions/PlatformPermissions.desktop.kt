package presentation.permissions

import androidx.compose.runtime.Composable

actual class PermissionsControllerFactory {
    @Composable
    actual fun createPermissionsController(): PermissionsController {
        return PermissionsController()
    }
}

actual class PermissionsController {
    actual suspend fun getPermissionState(permission: Permission): PermissionState {
        return PermissionState.NotDetermined
    }

    actual suspend fun providePermission(permission: Permission) {
        /** NO-OP */
    }

    actual fun openAppSettings() {
        /** NO-OP */
    }
}