package presentation.designsystem.components

import kotlinx.browser.window

actual class ShowMessageManagerImp: ShowMessageManager {
    actual override fun showMessage(
        message: String,
        duration: Duration
    ) {
        // show popup box here
        window.alert(message)
    }
}