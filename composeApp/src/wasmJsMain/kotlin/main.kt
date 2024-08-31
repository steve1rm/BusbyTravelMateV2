import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import di.initializeKoin
import di.wasmSpecificModule
import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.js.Js
import kotlinx.browser.document
import kotlinx.browser.window
import org.koin.dsl.module

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {

        window.localStorage

        initializeKoin(
            koinConfig = {
                modules(
                    wasmSpecificModule,
                    module {
                        this.single<HttpClientEngine> {
                            HttpClient(Js).engine
                        }
                    })
            })

        App()
    }
}
