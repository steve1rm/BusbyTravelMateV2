import androidx.compose.ui.window.ComposeUIViewController
import di.initializeKoin
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

fun MainViewController() = ComposeUIViewController {

    initializeKoinKt.initializeKoin()
    withContext(Dispatchers.IO) {
        TODO()
    }
    App()
}