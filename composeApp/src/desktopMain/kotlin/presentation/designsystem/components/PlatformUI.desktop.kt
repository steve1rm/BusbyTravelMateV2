package presentation.designsystem.components

import java.awt.*
import javax.swing.*

class ToastMessage(message: String, duration: Int) : JWindow() {
    init {
        val label = JLabel(message)
        label.isOpaque = true
        label.background = Color.BLACK
        label.foreground = Color.WHITE
        label.border = BorderFactory.createEmptyBorder(10, 10, 10, 10)
        add(label)
        pack()
        setLocationRelativeTo(null)
        isVisible = true

        Timer(duration) { dispose() }.start()
    }
}

actual class ShowMessageManagerImp : ShowMessageManager {
    actual override fun showMessage(
        message: String,
        duration: Duration
    ) {
        val toastDuration = when (duration) {
            Duration.SHORT_DURATION -> 4
            Duration.LONG_DURATION -> 8
        }

        ToastMessage(message, toastDuration)
    }
}