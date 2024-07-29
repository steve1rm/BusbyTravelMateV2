import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import data.createDataStore
import data.preference.CreateDateStorePath
import di.initializeKoin
import domain.preferences.PreferenceRepository.Companion.DATA_STORE_FILE_NAME
import org.koin.dsl.module

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BusbyTravelMateV2",
        ) {

            initializeKoin {
                modules(
                    module {
                        single { CreateDateStorePath()}
                    }
                )
            }
            App()
        }
    }
}
