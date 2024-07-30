import androidx.compose.ui.window.ComposeUIViewController
import di.initializeKoin

fun MainViewController() = ComposeUIViewController {

    initializeKoinKt.initializeKoin()
    App()
}