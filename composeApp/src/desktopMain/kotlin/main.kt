import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initializeKoin

fun main() {
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "BusbyTravelMateV2",
        ) {

            initializeKoin()

            App()
        }
    }
}