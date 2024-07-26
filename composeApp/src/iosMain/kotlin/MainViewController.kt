import androidx.compose.runtime.remember
import androidx.compose.ui.window.ComposeUIViewController
import di.initializeKoin

fun MainViewController() = ComposeUIViewController {

    initializeKoinKt.initializeKoin()

    App(
        dataStorePreferences = remember {
           createDataStore()
        }
    )
}