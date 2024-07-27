import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.viewmodel.compose.viewModel
import cafe.adriel.voyager.navigator.Navigator
import co.touchlab.kermit.Logger
import co.touchlab.kermit.Logger.Companion
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import presentation.designsystem.ui.theme.DarkColorScheme
import presentation.navigation.LoginScreenRoute
import presentation.permissions.PermissionState
import presentation.permissions.PermissionViewModel
import presentation.permissions.PermissionsControllerFactory

@Composable
@Preview
fun App(dataStorePreferences: DataStore<Preferences>) {
    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = MaterialTheme.typography,
    ) {
        val scope = rememberCoroutineScope()

        dataStorePreferences
            .data
            .onEach {
            val tokenKey = stringPreferencesKey("TOKEN")
            Logger.setTag("BusbyTravelMate")
            Logger.d(message = { "This has been inserted on LaunchIn [ ${it[tokenKey]} ]" },)
        }.launchIn(scope)

        val token by dataStorePreferences.data
            .onEach { preference ->
                val tokenKey = stringPreferencesKey("TOKEN")
                Logger.setTag("BusbyTravelMate")
                Logger.d(message = { "This has been inserted collectAsState [ ${preference[tokenKey]} ]" },)
                preference[tokenKey]
            }
            .collectAsState("")

        permissionNotificationHandler()

        scope.launch {
            dataStorePreferences.edit { preference ->
                val tokenKey = stringPreferencesKey("TOKEN")
                preference[tokenKey] = "steve"
            }
        }

        KoinContext {
            Navigator(screen = LoginScreenRoute)
        }
    }
}

@Composable
private fun permissionNotificationHandler() {
    val permissionsControllerFactory = PermissionsControllerFactory()
    val permissionsController = permissionsControllerFactory.createPermissionsController()

    val permissionViewModel = viewModel {
        PermissionViewModel(permissionsController)
    }

    when (permissionViewModel.permissionState) {
        PermissionState.NotDetermined -> {
            Logger.d { "PermissionState.NotDetermined" }
        }

        PermissionState.NotGranted -> {
            Logger.d { "PermissionState.NotGranted" }
            permissionViewModel.provideOrRequestNotificationPermission()
        }

        PermissionState.Granted -> {
            Logger.d { "PermissionState.Granted" }
        }

        PermissionState.Denied -> {
            Logger.d { "PermissionState.Denied" }
            permissionViewModel.provideOrRequestNotificationPermission()
        }

        PermissionState.DeniedAlways -> {
            Logger.d { "PermissionState.DeniedAlways" }

            permissionsController.openAppSettings()
        }
    }
}


/*
 var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
 */