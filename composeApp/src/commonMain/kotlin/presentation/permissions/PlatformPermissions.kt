package presentation.permissions

import androidx.compose.runtime.Composable

expect class PermissionsControllerFactory() {
    @Composable
    fun createPermissionsController(): PermissionsController
}

expect class PermissionsController {
    suspend fun getPermissionState(permission: Permission): PermissionState
    suspend fun providePermission(permission: Permission)
    fun openAppSettings()
}

enum class Permission {
    REMOTE_NOTIFICATION
}

enum class PermissionState {
    NotDetermined,
    NotGranted,
    Granted,
    Denied,
    DeniedAlways
}

class DeniedAlwaysException : Exception()
class DeniedException : Exception()
class RequestCanceledException : Exception()