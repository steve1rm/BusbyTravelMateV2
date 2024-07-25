package presentation.permissions

import androidx.compose.runtime.Composable


actual class PermissionsControllerFactory {
    @Composable
    actual fun createPermissionsController(): PermissionsController {
        TODO("Not yet implemented")
    }
}

actual class PermissionsController {
    actual suspend fun getPermissionState(permission: Permission): PermissionState {
        TODO("Not yet implemented")
    }

    actual suspend fun providePermission(permission: Permission) {
    }

    actual  fun openAppSettings() {
    }
}