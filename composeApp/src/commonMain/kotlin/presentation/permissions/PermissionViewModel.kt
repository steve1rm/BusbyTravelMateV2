package presentation.permissions

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class PermissionViewModel(private val permissionsController: PermissionsController) : ViewModel() {

    var permissionState by mutableStateOf(PermissionState.NotDetermined)
        private set

    init {
        viewModelScope.launch {
            permissionState = permissionsController.getPermissionState(Permission.REMOTE_NOTIFICATION)
        }
    }

    fun provideOrRequestNotificationPermission() {
        viewModelScope.launch {
            try {
                permissionsController.providePermission(Permission.REMOTE_NOTIFICATION)
                permissionState = PermissionState.Granted
            } catch (exception: DeniedAlwaysException) {
                permissionState = PermissionState.DeniedAlways
            } catch (exception: DeniedException) {
                permissionState = PermissionState.Denied
            } catch (exception: RequestCanceledException) {
                exception.printStackTrace()
            }
        }
    }
}
