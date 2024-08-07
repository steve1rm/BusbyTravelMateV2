import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import di.initializeKoin
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.cio.CIO
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
                        single<HttpClientEngine> {
                            HttpClient(CIO).engine
                        }
                    }
                )
            }

            App()
        }
    }
}