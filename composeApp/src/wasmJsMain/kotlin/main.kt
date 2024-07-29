import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import data.preference.CreateDateStorePath
import di.initializeKoin
import kotlinx.browser.document
import org.koin.dsl.module

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        initializeKoin {
            modules(
                modules = module {
                    single {
                        CreateDateStorePath()
                    }
                }
            )
        }
        App()
    }
}