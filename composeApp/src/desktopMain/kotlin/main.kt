import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.DATA_STORE_FILE_NAME
import data.createDataStore
import di.initializeKoin

fun main() {
    val localDataStorePreferences = createDataStore {
        DATA_STORE_FILE_NAME
    }

    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BusbyTravelMateV2",
        ) {

            initializeKoin()

            App(
                dataStorePreferences = localDataStorePreferences
            )
        }
    }
}