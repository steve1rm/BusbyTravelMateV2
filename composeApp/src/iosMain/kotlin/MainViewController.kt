import androidx.compose.ui.window.ComposeUIViewController
import data.preference.CreateDateStorePath
import di.initializeKoin
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController {

    initializeKoinKt.initializeKoin {
        module {
            single {
                CreateDateStorePath()
            }
        }
    }

    App()
}